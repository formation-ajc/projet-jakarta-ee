package com.projet.projetjakartaee.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private LocalDate createdAt;
	@OneToMany(mappedBy = "ingredient")
	private List<IngredientRecipe> ingredientRecipes;
	
	public Ingredient() {
		super();
	}
	public Ingredient(String name, LocalDate createdAt) {
		super();
		this.name = name;
		this.createdAt = createdAt;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	public List<IngredientRecipe> getIngredientRecipes() {
		return ingredientRecipes;
	}
	public void setIngredientRecipes(List<IngredientRecipe> ingredientRecipes) {
		this.ingredientRecipes = ingredientRecipes;
	}
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", createdAt=" + createdAt + "]";
	}
	
	
}
