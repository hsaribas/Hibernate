package com.hb13.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
	
	public static void main(String[] args) {
		
		Student13 student1=new Student13();
		student1.setName("John Coffee");
		student1.setMathGrade(80);
		
		Student13 student2=new Student13();
		student2.setName("James Bond");
		student2.setMathGrade(90);
		
		Student13 student3=new Student13();
		student3.setName("Tony Stark");
		student3.setMathGrade(90);
		
		

		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student13.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
	     //session.save(student1);
	     
	    // session.save(student2);
		
		// session.persist(student3);
	     
	     //student2.setName("James Bond is in Persistent state ");
	     
	     
	     //session.persist(student1);
	    // session.save(student2);
	    
		//it makes data to write into database, makes data permanent 
		
		Student13 student4= session.get(Student13.class, 1);
		
		//student4.setName("Bla Bla");
		
		//it is in the detached state
		session.evict(student4);
		
		//take the entity to persistent state again.
		session.update(student4);
		
		student4.setName("After evict");
		
		//goes to removed state
		//session.delete(student4);
		
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		
		//student3.setName("Tom Thanks");
		sf.close();
		
	}

}
