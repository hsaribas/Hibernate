package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {

		Student02 student1 = new Student02();
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(10);

//        Student02 student2 = new Student02();
//        student2.setId(1003);
//        student2.setName("Tony Stark");
//        student2.setGrade(10);

        Address address = new Address();
        address.setStreet("Apple Street");
        address.setCity("New York");
        address.setZipCode("23455");
        address.setCountry("US");

        student1.setAddress(address);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student1);
//        session.save(student2);

        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();
    }
}