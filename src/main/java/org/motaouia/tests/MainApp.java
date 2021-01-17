package org.motaouia.tests;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.motaouia.entities.Address;
import org.motaouia.entities.Employee;
import org.motaouia.utils.HibernateUtilsII;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
	      Transaction transaction = null;
	      try {
	         session = HibernateUtilsII.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	         //transaction.begin();
	         //session.getTransaction();

	         Address address1 = new Address("Bengaluru", "Karnataka", "India", "560016");
	         Address address2 = new Address("Jaipur", "Rajasthan", "India", "302017");

	         // Employee1 have 2 addresses
	         Employee employee1 = new Employee("Ravindra Singh", "Sales Manager", 450000);
	         employee1.getAddresses().add(address1);
	         employee1.getAddresses().add(address2);

	         // Employee2 have 1 address
	         Employee employee2 = new Employee("Mohit Sharma", "Software Engineer", 850000);
	         employee2.getAddresses().add(address1);

	         session.save(employee1);
	         session.save(employee2);
	         transaction.commit();
	         HibernateUtilsII.getSessionFactory().close();
	        

	         System.out.println("Records saved successfully");

	      } catch (Exception e) {
	         if (transaction != null) {
	            System.out.println("Transaction is being rolled back.");
	            transaction.rollback();
	         }
	         e.printStackTrace();
	      } finally {
	        /* if (session != null) {
	            session.close();
	            //HibernateUtilsII.getSessionFactory().close();
	         }*/
	      }
	      HibernateUtilsII.shutdown();
	   }

	}


