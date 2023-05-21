package com.example.demo.student;

import com.example.demo.StudentRepository;
import com.example.demo.exeption.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class StudentDataSource extends DataSource<Student,Integer> {

    @Autowired

    final private StudentRepository repository;
  public  StudentDataSource(StudentRepository repository){
      this.repository = repository;
  };


    @Override
    public Student getData(Integer id) throws DataException {
        Optional<Student> studentTemp = repository.findById(id);

         if (studentTemp.get() == null){
             throw new DataException("Student isn't found");
         }
         else
             return studentTemp.get();
    }

    public  void addStudent(Student student) {

        repository.save(student);

    }

    public List<Student> getStudents(){

        return repository.findAll();
    }

}
