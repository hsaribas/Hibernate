package com.hb03.onetoone;

import javax.persistence.*;

@Entity
public class Student03 {

    @Id
    //@Column(name = "s_id") //you can change default id column name
    private int id;

    @Column(name = "std_name")
    private String name;

    @Transient //if you don't want to keep this data in the database, you can use @Transient
    private int grade;

    @OneToOne(mappedBy = "student")
    private Diary diary;

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

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    @Override
    public String toString() {
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", diary=" + diary +
                '}';
    }

//    @Lob //CLOB
//    private String somedata;
//
//    @Lob //BLOB
//    private byte [] photo;

}
