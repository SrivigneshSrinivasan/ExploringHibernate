package com.exploringhibernate;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.exploringhibernate.recipes.Recipe;

public class MainClass {

	public static void main(String[] args) throws SQLException {

		// Code to test JDBC Connectivity
		// Connection conn =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		// "testuser", "test");
		// boolean reachable = conn.isValid(5);
		// System.out.println("Can connect to DB? : "+reachable);
		
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure();
		new SchemaExport(config).create(true, true);
		SessionFactory factory = config.buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();
		Recipe recipe = new Recipe();
		recipe.setRecipeId(1);
		recipe.setRecipeName("Sambar");
		recipe.setDescription("Description of Sambar");

		session.save(recipe);
		session.getTransaction().commit();

	}

}
