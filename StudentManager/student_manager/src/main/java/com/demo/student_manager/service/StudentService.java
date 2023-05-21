package com.demo.student_manager.service;

import com.demo.student_manager.core.Course;
import com.demo.student_manager.core.Student;
import com.demo.student_manager.data.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    DataManager dataManager;
    @Autowired
    public StudentService(DataManager dataManager){
        this.dataManager = dataManager;
    }


    public Page<Student> getPage(Pageable pageable){
     return dataManager.getStudentPage(pageable);
    }

    public List<Course> getAllCourses(){
        return dataManager.getAllCourses();
    }

}
