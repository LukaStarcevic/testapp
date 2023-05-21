package com.example.demo.student;

import com.example.demo.core.Response;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Student extends Response {


      @NotNull
     private String name;
    @NotNull
    @Id
      private int jmbag;
    @NotNull
    private String surname;
    public Student(String name, int jmbag, String surname) {
        this.name = name;
        this.jmbag = jmbag;
        this.surname = surname;
    }
    public Student(){}
      public  Student(String name,String surname){
        this.name=name;
        this.surname= surname;
      }
     public int getJMBAG() {return  this.jmbag;}
     public  String getName() {return  this.name;}
     public String getSurname() {return  this.surname;}

      public void  setName (String name){
        this.name= name;
      }

      public void  setJMBAG (int JMBAG){
          this.jmbag= JMBAG;
      }
      public void  setSurname (String surname){
          this.surname= surname;
      }

      @Override
      public String toString() {
          return  "Student{"+
                  ", name="+name +'\n'+
                  ", JMBAG=" + jmbag +'\n' +
                  ", surname="+ surname +'}';


      }
  }
