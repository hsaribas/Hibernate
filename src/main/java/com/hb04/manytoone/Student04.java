package com.hb04.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student04")
public class Student04 {

    /*
     * @Id annotation makes variable primary key
     * it uniquely identifies each row in a table
     * it must be unique
     * can not contain NULL values
    */

    @Id
    private int id;

    @Column(name="student_name", nullable = false, unique = false)
    private String name;

    private int grade;

    @Column(name="created_on")
    private LocalDateTime createOn;

    @Column(name="update_on")
    private LocalDateTime updateOn;

    @ManyToOne
    @JoinColumn(name="university_id")
    private University university;

    @PrePersist
    public void prePersist(){
        createOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updateOn = LocalDateTime.now();
    }

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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    public LocalDateTime getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(LocalDateTime updateOn) {
        this.updateOn = updateOn;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", updateOn=" + updateOn +
                ", university=" + university +
                '}';
    }
}