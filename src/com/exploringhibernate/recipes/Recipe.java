package com.exploringhibernate.recipes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recipe {
	@Id
	private int recipeId;
	private String recipeName;
	private String description;
	
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
