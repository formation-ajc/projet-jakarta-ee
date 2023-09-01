package com.projet.projetjakartaee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredientRecipe")
public class IngredientRecipe {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer quantite;
	@ManyToOne
	@JoinColumn(name = "idRecipe")
	private Recipe recipe;
	@ManyToOne
	@JoinColumn(name = "idIngredient")
	private Ingredient ingredient;
	
	public IngredientRecipe() {
		super();
	}

	public IngredientRecipe(Integer quantite) {
		super();
		this.quantite = quantite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
		return "IngredientRecipe [id=" + id + ", quantite=" + quantite + "]";
	}
	
}
