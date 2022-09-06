package com.hb08.fetchtypes;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
	

	public static void main(String[] args) {

		Student08 student= getStudent();
		
		//it create LazyInýtException because after session closed we cant access related entities with LAzy fetch Type
		//System.out.println(student.getBookList().size());
		
		List<Book08> bookList= getBooksById(student.getId());
		System.out.println("Book List Size:"+bookList.size());
		for (Book08 book08 : bookList) {
			System.out.println(book08.getBookName());
		}
	}
	
	private static List<Book08> getBooksById(int id){

		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		Transaction tx= session.beginTransaction();
		
	 
		//Student08 student= session.get(Student08.class, id);
		//List<Book08> bookList= student.getBookList();
		
		List<Book08> bookList=session.createQuery("FROM Book08 b where b.student="+id,Book08.class).getResultList();
		
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		
		//if your fetch type is lazy when you want to access a related object you can get LazyInitializationException
		//System.out.println(student.getBookList());

		sf.close();
		
		return bookList;
	}
	
	private static Student08 getStudent() {

		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		Transaction tx= session.beginTransaction();
		
		//EAGER
//		select
//     student08x0_.id as id1_1_0_,
//     student08x0_.grade as grade2_1_0_,
//     student08x0_.student_name as student_3_1_0_,
//     booklist1_.student_id as student_3_0_1_,
//     booklist1_.id as id1_0_1_,
//     booklist1_.id as id1_0_2_,
//     booklist1_.bookName as bookname2_0_2_,
//     booklist1_.student_id as student_3_0_2_ 
// from
//     Student08 student08x0_ 
// left outer join
//     Book08 booklist1_ 
//         on student08x0_.id=booklist1_.student_id 
// where
//     student08x0_.id=?
	 
		Student08 student= session.get(Student08.class, 1001);
	
		//System.out.println(student);
		
//		List<Book08> bookList= student.getBookList();

//		for (Book08 book08 : bookList) {
//			System.out.println(book08);
//		}
//		
		
		//session.delete(student);
		

		//it makes data to write into database, makes data permanent 
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		
		//if your fetch type is lazy when you want to access a related object you can get LazyInitializationException
		//System.out.println(student.getBookList());

		sf.close();
		
		return student;
	}

}
