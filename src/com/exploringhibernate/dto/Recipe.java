package com.exploringhibernate.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "table_recipe")
public class Recipe {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int recipeId;
	@Column(name = "Recipe_Name")
	private String recipeName;
	@Column(name = "Recipe_Description")
	private String recipeDescription;
	@Temporal(TemporalType.DATE)
	private Date recipeIntroDate;

	// @Id
	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	// @Column(name = "Recipe_Name")
	public String getRecipeName() {
		return recipeName + " from Hibernate";
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	// @Column(name = "Recipe_Description")
	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	// @Temporal(TemporalType.DATE)
	public Date getRecipeIntroDate() {
		return recipeIntroDate;
	}

	public void setRecipeIntroDate(Date recipeIntroDate) {
		this.recipeIntroDate = recipeIntroDate;
	}

	public String toString() {

		String recipe = "Recipe Id: " + recipeId + "\nRecipe Name: " + recipeName + "\nRecipe Description: "
				+ recipeDescription + "\nRecipe Intro Date: " + recipeIntroDate.toString();

		return recipe;

	}

}
