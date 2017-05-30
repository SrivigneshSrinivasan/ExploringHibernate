package com.exploringhibernate.embedding;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.exploringhibernate.dto.Address;
import com.exploringhibernate.dto.UserDetails;

public class HibernateTestDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails user = new UserDetails(); // create an user is entity type
												// object
		// user.setUserId(1);
		user.setUserName("Dinesh Rajput");

		Address address = new Address(); // create an value type object of
											// address class for home address
		address.setStreet("Block House No");
		address.setCity("MangolaPuri");
		address.setState("New Delhi");
		address.setPincode("110089");
		user.setHomeAddress(address); // set the home address

		Address address1 = new Address();// create another value type object for
											// the permanent address
		address1.setStreet("Film City");
		address1.setCity("Noida");
		address1.setState("UP");
		address1.setPincode("201301");
		user.setPermanentAddress(address1);// set the permanent address

		user.setJoinDate(new Date());
		user.setPhone("9999222211");

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); // create
																											// a
																											// session
																											// factory
																											// object
		Session session = sessionFactory.openSession(); // create a session
														// object
		session.beginTransaction(); // transaction object start
		session.save(user); // save the entity type object user to the database
		session.getTransaction().commit(); // commit the transaction object
		session.close(); // close the session
	}
}
