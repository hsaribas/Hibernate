package com.hb11.caching;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
	
	public static void main(String[] args) {
		
		Student11 student1=new Student11();
		student1.setName("John Coffee");
		student1.setMathGrade(80);
		
		Student11 student2=new Student11();
		student2.setName("James Bond");
		student2.setMathGrade(90);
		
		Student11 student3=new Student11();
		student3.setName("Tony Stark");
		student3.setMathGrade(85);
		
		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student11.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
	     session.save(student1);
	     session.save(student2);
	     session.save(student3);
	    
		//it makes data to write into database, makes data permanent 
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		sf.close();
		
	}

}
