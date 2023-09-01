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
import com.projet.projetjakartaee.repository.RecipeRepository;

import jakarta.persistence.EntityManagerFactory;

@WebServlet(name = "/DeleteRecipeServlet", value = "/deleteRecipe")
public class DeleteRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteRecipeServlet() {
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
				recipeRep.delete(currentRecipeId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect(request.getContextPath() + "/recipe");
	}


}
