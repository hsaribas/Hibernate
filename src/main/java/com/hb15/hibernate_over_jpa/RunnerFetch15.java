package com.hb15.hibernate_over_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerFetch15 {
	public static void main(String[] args) {
	
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentunit");
		EntityManager em=emf.createEntityManager();

		em.getTransaction().begin();
		
		Student15 student1= em.find(Student15.class, 1);

		System.out.println(student1);
		
		em.remove(student1);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
