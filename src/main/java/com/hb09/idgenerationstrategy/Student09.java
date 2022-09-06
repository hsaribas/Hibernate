package com.hb09.idgenerationstrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student09 extends BaseEntity {

    /*
     * @Id annotation makes variable primary key
     * it uniquely identifies each row in a table
     * it must be unique
     * can not contain NULL values
    */

    //@Id
    //@GeneratedValue //AUTO
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.TABLE)

//	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name="sequence", sequenceName ="student_seq", initialValue = 1000, allocationSize = 50)

//	@GeneratedValue(generator="UUID")
//	@GenericGenerator(name="UUID", strategy="uuid2")
//	private String id;
    //8-4-4-4-12=32 characters,128 bits

    //private int id;

    @Column(name="student_name", length=100, nullable=false, unique = false)
    private String name;

    private int grade;

        //public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student09 [id=" + getId() + ", name=" + name + ", grade=" + grade + "]";
    }

}
