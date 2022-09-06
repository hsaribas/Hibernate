package com.hb06.bi_onetomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student06 {

    /*
     * @Id annotation makes variable primary key
     * it uniquely identifies each row in a table
     * it must be unique
     * can not contain NULL values
    */

    @Id
    private int id;

    @Column(name="student_name",nullable=false, unique = false)
    private String name;

    private int grade;

    //@OneToMany(mappedBy ="student")
    @OneToMany(mappedBy = "student", orphanRemoval = true) //we added orphanRemoval attribute to test deletion
    private List<Book06> bookList=new ArrayList<>();

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book06> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student06 [id=" + id + ", name=" + name + ", grade=" + grade + ", bookList=" + bookList + "]";
    }
}
