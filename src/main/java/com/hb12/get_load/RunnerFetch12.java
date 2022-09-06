package com.hb12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student12.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

//		System.out.println("Start to execute get method....");
//		Student12 student1= session.get(Student12.class,1 );
//		System.out.println("Finish to execute get method....");

//		System.out.println("Student ID:"+student1.getId());
//		System.out.println("Student Get Name:"+student1.getName());

//		System.out.println("----------------------------------------------------");

//		System.out.println("Start to execute load method....");
//		Student12 student2= session.load(Student12.class, 2);
//		System.out.println("Finish to execute load method....");

//		System.out.println("Student ID:"+student2.getId());
//		System.out.println("Student Load Name:"+student2.getName());

		
		//if there is no such an id, seee behavior of the get and load methods
//		System.out.println("Start to execute get method....");
//		Student12 student1 = session.get(Student12.class, 10); //10 is not in the database
//		System.out.println("Finish to execute get method....");

//		if (student1 != null) {
//			System.out.println("Student ID:" + student1.getId());
//			System.out.println("Student Get Name:" + student1.getName());
//		}

//		System.out.println("----------------------------------------------------");

//		System.out.println("Start to execute load method....");
//		Student12 student2 = session.load(Student12.class, 15);//15 is not in the database
//		System.out.println("Finish to execute load method....");

//		if (student2 != null) {
//			System.out.println("Student ID:" + student2.getId());
//			System.out.println("Student Load Name:" + student2.getName());
//		}
		
		Student12 student3= session.load(Student12.class, 1);
		
		// you can create a relation with other object with load method without getting all data
		session.delete(student3);

		tx.commit();
		session.close();

		sf.close();
	}

}
