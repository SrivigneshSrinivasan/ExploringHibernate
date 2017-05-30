package com.exploringhibernate.embedding;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.exploringhibernate.dto.Animal;
import com.exploringhibernate.dto.Elephant;
import com.exploringhibernate.dto.Lion;

public class EmbeddingObjects {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Animal animal = new Animal("Lion A", "Africa");
		Lion lion = new Lion(1, animal);
		animal = new Animal("Elephnat A", "Asia");
		Elephant elephant = new Elephant(1, animal);
		session.save(lion);
		session.save(elephant);
		session.getTransaction().commit();
		session.close();
	}

}
