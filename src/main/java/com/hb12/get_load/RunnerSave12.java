package com.hb12.get_load;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
	
	public static void main(String[] args) {
		
		Student12 student1=new Student12();
		student1.setName("John Coffee");
		student1.setMathGrade(80);
		
		Student12 student2=new Student12();
		student2.setName("James Bond");
		student2.setMathGrade(90);
		

		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student12.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
		//session.save(student1);
		session.save(student2);
	    
		//it makes data to write into database, makes data permanent 
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		sf.close();
		
	}

}
