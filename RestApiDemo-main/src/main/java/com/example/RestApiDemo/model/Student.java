package com.example.RestApiDemo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
    public Student() {

    }

    public Student(Book book, Integer studentId, String studentName, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.book = book;

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_name")
    private String studentName;
    private String department;
    @OneToOne
    public Book book;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student [book=" + book + ", studentId=" + studentId + ", studentName=" + studentName + ", department="
                + department + "]";
    }

    public Student(Integer studentId, String studentName, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
    }

}
