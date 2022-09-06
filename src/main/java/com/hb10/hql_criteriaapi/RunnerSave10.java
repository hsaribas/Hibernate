package com.hb10.hql_criteriaapi;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
	
	public static void main(String[] args) {
		
		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student10.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
		Random random=new Random();
		
	     for (int i = 1; i <=50; i++) {
	    		Student10 student1=new Student10();
	    		student1.setName("Name "+i);
	    		student1.setMathGrade(random.nextInt(100));
	    		session.save(student1);
		}

		//it makes data to write into database, makes data permanent 
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		sf.close();
		
	}

}
