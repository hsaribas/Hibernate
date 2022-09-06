package com.hb11.caching;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region = "Student11")

public class Student11 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name="student_name",length=100, nullable=false, unique = false) 
	private String name;
    
    private int mathGrade;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMathGrade() {
		return mathGrade;
	}

	public void setMathGrade(int grade) {
		this.mathGrade = grade;
	}


	@Override
	public String toString() {
		return "Student11 [id=" + id + ", name=" + name + ", grade=" + mathGrade + "]";
	}

	
}
