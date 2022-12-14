package com.hb09.idgenerationstrategy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {

    public static void main(String[] args) {

        Student09 student1=new Student09();
        student1.setName("John Coffee");
        student1.setGrade(10);

        Student09 student2=new Student09();
        student2.setName("James Bond");
        student2.setGrade(11);

        Student09 student3=new Student09();
        student3.setName("Tony Stark");
        student3.setGrade(9);

        Book09 book=new Book09();
        book.setName("Art Book");


        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book);

        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }

}
