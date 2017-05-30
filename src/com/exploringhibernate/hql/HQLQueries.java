package com.exploringhibernate.hql;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.exploringhibernate.dto.Recipe;

public class HQLQueries {

	public static void main(String[] args) throws SQLException {

		// Code to test JDBC Connectivity
		// Connection conn =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		// "testuser", "test");
		// boolean reachable = conn.isValid(5);
		// System.out.println("Can connect to DB? : "+reachable);

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		SessionFactory factory = config.buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();
		Recipe recipe = new Recipe();
		recipe.setRecipeId(1);
		recipe.setRecipeName("Sambar");
		recipe.setRecipeDescription("Description of Sambar");

		Recipe recipe1 = new Recipe();
		recipe1.setRecipeId(2);
		recipe1.setRecipeName("Fish Fry");
		recipe1.setRecipeDescription("Description of Fish Fry");

		session.persist(recipe);
		session.persist(recipe1);
		session.getTransaction().commit();

	}

}
