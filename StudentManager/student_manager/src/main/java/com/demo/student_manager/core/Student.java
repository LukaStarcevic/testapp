package com.demo.student_manager.core;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;


@Entity
public class Student {

    @Column(name = "studnet_name")
    private  String name;
    private String surname;
    @Column(name = "orinetation_id")
    private int orientationId;
    private String email;
    @Column(name = "studies_year")
    private  int year;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int jmbag;

    public int getJmbag() {
        return jmbag;
    }

    public int getOrientationId() {
        return orientationId;
    }

    public int getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJmbag(int jmbag) {
        this.jmbag = jmbag;
    }

    public void setOrientationId(int orientationId) {
        this.orientationId = orientationId;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStudnet_name(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Student(String name,  int year, String email, int orientationId, String surname){
        this.name = name;
        this.year = year;
        this.surname = surname;
        this.email = email;
        this.orientationId = orientationId;
    }


    public  Student(){};

    @Override
    public String toString() {
        return "Student{name"+name+"\n"+
                "surname"+surname+"\n"+
                "orientation_id"+orientationId+"\n"+
                "email"+email+"\n"+
                "studYear"+year;
    }
}
