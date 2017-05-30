package com.exploringhibernate.embedding;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.exploringhibernate.dto.Animal;
import com.exploringhibernate.dto.Elephant;
import com.exploringhibernate.dto.Lion;

public class EmbeddingObjects {

	private static final SessionFactory concreteSessionFactory;
	static {
		try {
			concreteSessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return concreteSessionFactory.openSession();
	}

	public static void main(String[] args) {
		Session session = getSession();
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
