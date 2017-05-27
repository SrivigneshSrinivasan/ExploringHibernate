package com.exploringhibernate.recipes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {
	
	@Id
	private int ingredientId;
	private String ingredientName;
	private String ingredientQuantity;
	
	
	public int getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public String getIngredientQuantity() {
		return ingredientQuantity;
	}
	public void setIngredientQuantity(String ingredientQuantity) {
		this.ingredientQuantity = ingredientQuantity;
	}
	
	
	
	

}
