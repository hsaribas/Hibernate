package com.hb11.caching;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch11 {

	public static void main(String[] args) {

		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student11.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
		//if you same identifier in the same session, record will be get from the 1. level cache for the second fetch
		//Student11 student1=session.get(Student11.class, 1);
		
		//clear the cache
		//session.clear();
		
		//Student11 student2=session.get(Student11.class, 1);
		
		//Student11 student2=session.get(Student11.class, 2);
		

		String hqlQuery="FROM Student11 s where s.id=1";
		Query<Student11>  query=session.createQuery(hqlQuery);
		query.setCacheable(true);
		List<Student11> resultList= query.getResultList();
		
		System.out.println(resultList);
		
		
		String hqlQuery2="FROM Student11 s where s.id=1";
		Query<Student11>  query2=session.createQuery(hqlQuery2);
		query2.setCacheable(true);
		List<Student11> resultList2= query2.getResultList();
		
		System.out.println(resultList2);

		tx.commit();
		
		//close session1
		session.close();
		

//		Session session2= sf.openSession();
//		Transaction tx2= session2.beginTransaction();
//		
//		Student11 student3=session2.get(Student11.class, 1);
//		
//		
//		tx2.commit();
//		//closing session2
//		session2.close();

		sf.close();
	}

}
