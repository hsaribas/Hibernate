package com.hb14.concurrency_locktype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
	
	public static void main(String[] args) {
		
		Student14 student1=new Student14();
		student1.setName("John Coffee");
		student1.setMathGrade(80);
		
		Student14 student2=new Student14();
		student2.setName("James Bond");
		student2.setMathGrade(90);

		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student14.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
	
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		
		//student3.setName("Tom Thanks");
		sf.close();
		
	}

}
