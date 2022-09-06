package com.hb14.concurrency_locktype;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch14 {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student14.class);

		SessionFactory sf = con.buildSessionFactory();
		
		Session session3= sf.openSession();
		
		System.out.println("after open session....");
		 
		Transaction tx= session3.beginTransaction();
		
		System.out.println("after transaction begin....");
		
	    Student14 student3=	session3.get(Student14.class, 1,LockMode.PESSIMISTIC_WRITE);
		
	    System.out.println("after get student");
	    
		tx.commit();
		session3.close();
		
		System.out.println("after session close");
		
		
		//this code about the optimistic lock.
//		Session session1 = sf.openSession();
//
//		Transaction tx1 = session1.beginTransaction();
//       
//		
//		Session session2= sf.openSession();
//		Transaction tx2= session2.beginTransaction();
//
//		
//		Student14 student1= session1.get(Student14.class, 1);
//		
//		Student14 student2= session2.get(Student14.class, 1);
//		
//		student1.setName("session1 student");
//		student2.setName("session2 student");
//		
//		tx2.commit();
//		
//		tx1.commit();
//		
//		session2.close();
//		session1.close();

		sf.close();
	}

}
