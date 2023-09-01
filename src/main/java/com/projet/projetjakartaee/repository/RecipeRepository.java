package com.projet.projetjakartaee.repository;

import com.projet.projetjakartaee.entity.Recipe;
import com.projet.projetjakartaee.repository.common.CommonRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class RecipeRepository extends CommonRepository<Recipe, Integer>{

	public RecipeRepository(EntityManagerFactory emf, Class<Recipe> tClass) {
		super(emf, tClass);
	}

	public Recipe getRecipeByName(String name) {
		EntityManager em = null;
		EntityTransaction tx = null;
		Recipe recipe = new Recipe();
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Recipe> tq = em.createQuery("SELECT r FROM Recipe r WHERE r.name = :name", Recipe.class);
			tq.setParameter("name", name);
			recipe = tq.getSingleResult();
			tx.commit();
			em.close();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null)
				em.close();
		}
		return recipe;
	}

	public Recipe getRecipeByDesc(String description) {
		EntityManager em = null;
		EntityTransaction tx = null;
		Recipe recipe = new Recipe();
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Recipe> tq = em.createQuery("SELECT r FROM Recipe r WHERE r.description = :description", Recipe.class);
			tq.setParameter("description", description);
			recipe = tq.getSingleResult();
			tx.commit();
			em.close();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null)
				em.close();
		}
		return recipe;
	}
	
	public Recipe getRecipeByKeyWord(String name) {
		EntityManager em = null;
		EntityTransaction tx = null;
		Recipe recipe = new Recipe();
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Recipe> tq = em.createQuery("SELECT r FROM Recipe r WHERE r.name LIKE :name", Recipe.class);
			tq.setParameter("name", "%" + name + "%");
			recipe = tq.getSingleResult();
			tx.commit();
			em.close();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null)
				em.close();
		}
		return recipe;
	}
	
}
