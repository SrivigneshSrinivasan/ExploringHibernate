package com.exploringhibernate.modelexample;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.exploringhibernate.dto.Ingredient;
import com.exploringhibernate.dto.Recipe;

public class ModelExample {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		SessionFactory factory = config.buildSessionFactory();

		//Insert data into DB
		Session session = factory.openSession();
		session.beginTransaction();
		
		Ingredient ingre = new Ingredient();
		ingre.setIngredientId(1);
		ingre.setIngredientName("Curry Leaves");
		ingre.setIngredientQuantity("Handful");
		
		Recipe recipe = new Recipe();
		recipe.setRecipeId(1);
		recipe.setRecipeName("Sambar");
		recipe.setRecipeDescription("Description of Sambar");
		recipe.setRecipeIntroDate(new Date());

		Recipe recipe1 = new Recipe();
		recipe1.setRecipeId(2);
		recipe1.setRecipeName("Fish Fry");
		recipe1.setRecipeDescription("Description of Fish Fry");
		recipe1.setRecipeIntroDate(new Date());

		session.persist(ingre);
		session.persist(recipe);
		session.persist(recipe1);
		session.getTransaction().commit();
		session.close();
		
		
		//retrieve files from DB
		session = factory.openSession();
		session.beginTransaction();
		Recipe rec = (Recipe) session.get(Recipe.class, 2);
		
		System.out.println(rec.toString());
		session.close();
		
		
		

	}

}
