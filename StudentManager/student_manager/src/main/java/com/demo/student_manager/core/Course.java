package com.demo.student_manager.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;


@Entity(name = "courses")
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "grade")
    private int grade;
    @Column(name = "studnet_name")
    private String studentName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "course_name")
    private String courseName;

    public Course(Long id,int grade,String studentName,String surname,String courseName){
        this.id = id;
        this.grade = grade;
        this.studentName = studentName;
        this.surname = surname;
        this.courseName = courseName;
    }
    public Course(){}

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", grade=" + grade +
                ", studentName='" + studentName + '\'' +
                ", surname='" + surname + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public int getGrade() {
        return grade;
    }

    public String getSurname() {
        return surname;
    }

    public long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentName() {
        return studentName;
    }

}
