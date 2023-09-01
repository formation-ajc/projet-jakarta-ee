package com.projet.projetjakartaee.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.projetjakartaee.database.Database;
import com.projet.projetjakartaee.entity.Recipe;
import com.projet.projetjakartaee.forms.AddRecipeForm;
import com.projet.projetjakartaee.forms.EditRecipeForm;
import com.projet.projetjakartaee.repository.RecipeRepository;

import jakarta.persistence.EntityManagerFactory;

@WebServlet(name = "/EditRecipeServlet", value = "/editRecipe")
public class EditRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/editRecipe.jsp";
	private static final String ATT_FORM = "form";
	private static final String ATT_RECIPE = "recipe";
       
 
    public EditRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Database.getInstanceEmf();
		RecipeRepository recipeRep = new RecipeRepository(emf, Recipe.class);
		String id = request.getParameter("idRecipe");
		if(id != null) {
			Integer currentRecipeId = Integer.parseInt(id);
					try {
						Recipe recipe = recipeRep.getById(currentRecipeId);
						request.setAttribute("rec", recipe);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			EditRecipeForm form = new EditRecipeForm();
			Recipe recipe = form.editRecipe(request);
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_RECIPE, recipe);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	


}

