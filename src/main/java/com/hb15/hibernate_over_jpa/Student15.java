package com.hb15.hibernate_over_jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Student15 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name="student_name",length=100, nullable=false, unique = false) 
	private String name;
    
    private int mathGrade;
    
    @Version
    private Long version;
    

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
		return "Student15 [id=" + id + ", name=" + name + ", grade=" + mathGrade + "]";
	}

	
}
