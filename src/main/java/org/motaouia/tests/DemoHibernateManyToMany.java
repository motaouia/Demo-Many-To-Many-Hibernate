package org.motaouia.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.motaouia.entities.Student;
import org.motaouia.entities.Subject;
import org.motaouia.utils.HibernateUtils;

public class DemoHibernateManyToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Student student1 = new Student("Sam","Disilva");
        Student student2 = new Student("Joshua", "Brill");
         
        Subject subject1 = new Subject("Economics");
        Subject subject2 = new Subject("Politics");
        Subject subject3 = new Subject("Foreign Affairs");
 
        //Student1 have 3 subjects
        student1.getSubjects().add(subject1);
        student1.getSubjects().add(subject2);
        student1.getSubjects().add(subject3);
         
        SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(student1);
		System.out.println("Before committing transaction");
		tx.commit();
		//session.close();
		sessionFactory.close();
		
		//System.out.println("Cart ID="+cart.getId());
		//System.out.println("Item1 ID="+item1.getId());
		//System.out.println("Item2 ID="+item2.getId());
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
	}

}
