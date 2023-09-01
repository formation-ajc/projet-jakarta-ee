package com.projet.projetjakartaee.forms;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import com.projet.projetjakartaee.database.Database;
import com.projet.projetjakartaee.entity.Recipe;
import com.projet.projetjakartaee.repository.RecipeRepository;


public class EditRecipeForm {

	private static final String CHAMP_ID = "id";
	private static final String CHAMP_NAME = "name";
	private static final String CHAMP_DESCRIPTION = "description";

	EntityManagerFactory emf = Database.getInstanceEmf();
	RecipeRepository recipeRepo = new RecipeRepository(emf, Recipe.class);
	private String success;
	private String fail;

	private Map<String, String> errors = new HashMap<String, String>();

	public String getSuccess() {
		return success;
	}

	public String getFail() {
		return fail;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public Recipe editRecipe(HttpServletRequest request) throws SQLException {

		String id = getValeurChamp(request, CHAMP_ID);
		String name = getValeurChamp(request, CHAMP_NAME);
		String description = getValeurChamp(request, CHAMP_DESCRIPTION);

		Recipe recipe = new Recipe();
		Integer idCurrentRecipe = validationId(id);
		if (idCurrentRecipe!= null) {
			recipe = recipeRepo.getById(idCurrentRecipe);

			try {
				validationName(name);
			} catch (Exception e) {
				setError(CHAMP_NAME, e.getMessage());
			}

			if (name.equals(recipeRepo.getRecipeByName(name).getName()) && description.equals(recipeRepo.getRecipeByDesc(description).getDescription())) {
				fail = "Cette recette existe déjà !";
			} else {
				recipe.setName(name);
				try {
					validationDescription(description);
				} catch (Exception e) {
					setError(CHAMP_DESCRIPTION, e.getMessage());
				}
				recipe.setDescription(description);

				if (errors.isEmpty()) {
					recipeRepo.update(recipe);
					success = "La recette a bien été modifiée.";
				} else {
					fail = "Modification echouée.";
				}
			}

		}
		return recipe;
	}

	private void validationName(String name) throws Exception {
		if (name == null) {
			throw new Exception("Merci de saisir un nom de recette.");
		}
	}

	private void validationDescription(String description) throws Exception {
		if (description != null) {
			if (description.length() < 10 || description.length() > 150) {
				throw new Exception("La description doit contenir entre 10 et 150 caractères !");
			}
		} else {
			throw new Exception("Merci de saisir une description.");
		}
	}

	private String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		}
		return valeur;
	}

	private void setError(String nomChamp, String message) {
		errors.put(nomChamp, message);
	}

	private static Integer validationId(String id) {
		Integer idCat = null;
		// le NOT implique l'utilisation de && et == implique l'utilisation de ||
		if (id != null && id != "" && id.matches("^\\d+$")) {
			idCat = Integer.parseInt(id);
		}
		return idCat;
	}
}
