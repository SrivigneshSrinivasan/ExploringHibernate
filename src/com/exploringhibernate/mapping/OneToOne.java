package com.exploringhibernate.mapping;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.exploringhibernate.dto.Student;
import com.exploringhibernate.dto.StudentAddress;

public class OneToOne {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); // create
		// session
		// factory
		// object
		Session session = sessionFactory.openSession(); // create session object
		// from the session
		// factory		
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			StudentAddress StudentAddress1 = new StudentAddress("OMR Road", "Chennai", "TN", "600097");
			StudentAddress StudentAddress2 = new StudentAddress("Ring Road", "Banglore", "Karnataka", "560000");
			Student student1 = new Student("Eswar", StudentAddress1);
			Student student2 = new Student("Joe", StudentAddress2);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
