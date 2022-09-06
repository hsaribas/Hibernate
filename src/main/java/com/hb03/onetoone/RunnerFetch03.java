package com.hb03.onetoone;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;

public class RunnerFetch03 {

    public static void main(String[] args) {

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

//      Diary diary= session.get(Diary.class, 101);
//		System.out.println(diary.getStudent());


//		Student03 student= session.get(Student03.class, 1001);
//		System.out.println(student);


//		String hqlQuery1="SELECT s.name,d.name FROM Student03 s INNER JOIN FETCH Diary d on s.id=d.student";
//		List<Object[]> resultList1= session.createQuery(hqlQuery1).getResultList();
//		for (Object[] r : resultList1) {
//			System.out.println(Arrays.toString(r));
//		}


//      String hqlQuery2="SELECT s.name,d.name FROM Student03 s RIGHT JOIN FETCH Diary d on s.id=d.student";
//		List<Object[]> resultList2= session.createQuery(hqlQuery2).getResultList();
//		for (Object[] r : resultList2) {
//			System.out.println(Arrays.toString(r));
//		}


//      String hqlQuery3="SELECT s.name,d.name FROM Student03 s LEFT JOIN FETCH Diary d on s.id=d.student";
//		List<Object[]> resultList3= session.createQuery(hqlQuery3).getResultList();
//		for (Object[] r : resultList3) {
//			System.out.println(Arrays.toString(r));
//		}


//		String hqlQuery4="FROM Student03 s INNER JOIN FETCH s.diary";
//		List<Student03> resulList4= session.createQuery(hqlQuery4).getResultList();
//		for (Student03 student03 : resulList4) {
//			System.out.println(student03);
//		}


//		String hqlQuery5="FROM Diary d INNER JOIN FETCH d.student";
//		List<Diary> resulList5= session.createQuery(hqlQuery5).getResultList();
//		for (Diary diary : resulList5) {
//			System.out.println(diary);
//		}


//        String hqlQuery6="SELECT new com.hb03.onetoone.CustomResult(s.name,d.name) FROM Student03 s inner "
//                + "join fetch Diary d on s.id=d.student";
//        List<CustomResult> results= session.createQuery(hqlQuery6).list();
//        for (CustomResult customResult : results) {
//            System.out.println(customResult);
//        }


//        Query query = session.createQuery("FROM Student03");
//        List<Student03> resultList6 = query.getResultList();
//        for(Student03 student03 : resultList6){
//            System.out.println(student03);
//        }

        tx.commit();

        session.close();
        sf.close();

    }
}