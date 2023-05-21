package com.demo.student_manager.service;

import com.demo.student_manager.core.Course;
import com.demo.student_manager.core.CoursePage;
import com.demo.student_manager.core.CourseSearchCriteria;
import com.demo.student_manager.data.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private DataManager dataManager;

    public List<Course> getCourses(CoursePage coursePage, CourseSearchCriteria courseSearchCriteria){
        return dataManager.getCourse(coursePage, courseSearchCriteria);
    }

    public List<Course> getAllCourses(){
        return dataManager.getAllCourses();
    }

}
