package com.hb07.manytomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book07 {

    @Id
    private int id;

    private String bookName;

    @Enumerated(EnumType.STRING)//you put string value of enum type into database
    private BookType type;

    @ManyToMany(mappedBy = "books")
    private List<Student07> students=new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book07 [id=" + id + ", bookName=" + bookName + ", type=" + type + "]";
    }

    public List<Student07> getStudents() {
        return students;
    }

    public void setStudents(List<Student07> students) {
        this.students = students;
    }
}