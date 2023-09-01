package com.projet.projetjakartaee.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private LocalDate createdAt;
	@OneToMany(mappedBy = "recipe")
	private List<IngredientRecipe> ingredientRecipes;

	
	public Recipe() {
		super();
	}
	public Recipe(String name, String description, LocalDate createdAt) {
		super();
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", createdAt=" + createdAt
				+ "]";
	}
}
