package com.hb07.manytomany;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

    public static void main(String[] args) {

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

//		Student07 student1= session.get(Student07.class, 1001);
//		for (Book07 book : student1.getBooks()) {
//			System.out.println(book);
//			for (Student07 std : book.getStudents()) {
//				System.out.println(std);
//			}
//		}


        //fetch student names
//		String hqlQuery1="SELECT s.name FROM Student07 s";
//		List<Object[]> resultList1= session.createQuery(hqlQuery1).getResultList();
//		System.out.println(resultList1);


        String hqlQuery2="SELECT s.name,b.bookName FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=1001";
        List<Object[]> resulList2= session.createQuery(hqlQuery2).getResultList();
        for (Object[] objects : resulList2) {
            System.out.println(Arrays.toString(objects));
        }


        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();
    }

}
