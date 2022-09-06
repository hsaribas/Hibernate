package com.hb05.uni_onetomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Student05 {

    /*
     * @Id annotation makes variable primary key
     * it uniquely identifies each row in a table
     * it must be unique
     * can not contain NULL values
    */
    @Id
    private int id;

    @Column(name="student_name", nullable=false, unique = false)
    private String name;

    private int grade;

    @OneToMany
    //@JoinColumn in order to avoid extra table
    private List<Book05> bookList=new ArrayList<>();

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

    public List<Book05> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book05> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
