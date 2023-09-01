package com.projet.projetjakartaee.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.projetjakartaee.database.Database;
import com.projet.projetjakartaee.entity.Recipe;
import com.projet.projetjakartaee.repository.RecipeRepository;

import jakarta.persistence.EntityManagerFactory;


@WebServlet(name = "/RecipieServlet", value = "/recipe")
public class RecipieServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/recipies.jsp";
	private static final String ATT_RECIPIES = "recipies";
	private String result;
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Database.getInstanceEmf();
		RecipeRepository recipeRepo = new RecipeRepository(emf, Recipe.class);
		List<Recipe> recipies = new ArrayList<>();
		try {
			recipies = recipeRepo.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(recipies.isEmpty()) {
			result = "La liste de recettes est vide !";
			request.setAttribute("result", result);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}else {
			request.setAttribute(ATT_RECIPIES, recipies);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
