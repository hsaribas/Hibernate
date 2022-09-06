package com.hb10.hql_criteriaapi;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch10 {

	public static void main(String[] args) {

		//CRUD
		//C-session.save
		//R-session.get,hql,sql
		//U-update query, session.update
		//D-session.delete and hql,sql

		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student10.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
//		String hqlQuery="FROM Student10 where mathGrade>50";
//		List<Student10> resultList= session.createQuery(hqlQuery,Student10.class).list();
//		resultList.forEach(System.out::println);


		//How to use a parameter in HQL
//		int studentId=10;
//		Query<Student10> query= session.createQuery("FROM Student10 s where s.id=:id",Student10.class);
//		query.setParameter("id", studentId);
//		List<Student10> resultList2= query.getResultList();
//		resultList2.forEach(System.out::println);

		
//		String hqlQuery2="SELECT sum(mathGrade) from Student10 where mathGrade>90";
//		Long sumMathGrade =(Long) session.createQuery(hqlQuery2).uniqueResult();
//		System.out.println("Total math Grade:"+sumMathGrade);


//		int mathGrade=90;
//		String hqlQuery3="SELECT avg(mathGrade) FROM Student10 where mathGrade>:mathGrade";
//		Query query2= session.createQuery(hqlQuery3);
//	    query2.setParameter("mathGrade", mathGrade);
//	    Double avgMathGrade=(Double)query2.uniqueResult();
//	    System.out.println("Avg math Grade:"+avgMathGrade);
		
		
		//UPDATE
//		Student10 student= session.get(Student10.class, 1);
//		student.setName("Updated "+student.getName());
//		session.update(student);


		//UPDATE HQL Example
//		String hqlQuery4="UPDATE Student10 s SET s.name='Updated with HQL' where s.id=11";
//		int numOfRec= session.createQuery(hqlQuery4).executeUpdate();
//		System.out.println("Effected Row Count:"+numOfRec);
		
		
//		String hqlQuery5="FROM Student10 s WHERE s.mathGrade<50";
//		List<Student10> resultList3= session.createQuery(hqlQuery5,Student10.class).getResultList();
//		for (Student10 student : resultList3) {
//			student.setMathGrade(50);
//			session.update(student);
//		}
		
		
//		String hqlQuery6="UPDATE Student10 s SET s.mathGrade=75 where s.mathGrade<75";
//		int numOfRec2= session.createQuery(hqlQuery6).executeUpdate();
//		System.out.println("Effected Row Count:"+numOfRec2);

		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Student10> criteriaQuery= cb.createQuery(Student10.class);
		Root<Student10> root= criteriaQuery.from(Student10.class);
		
		//criteriaQuery.select(root);
		//criteriaQuery.select(root).where(cb.equal(root.get("name"),"Name 10"));
		//criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),50));
		criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),90));
		
		
		Query<Student10> query= session.createQuery(criteriaQuery);
		List<Student10> resultList4= query.getResultList();
		resultList4.forEach(System.out::println);
	    
		//it makes data to write into database, makes data permanent 
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		sf.close();
	}

}
