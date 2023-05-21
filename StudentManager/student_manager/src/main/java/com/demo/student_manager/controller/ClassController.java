package com.demo.student_manager.controller;

import com.demo.student_manager.core.Course;
import com.demo.student_manager.core.CoursePage;
import com.demo.student_manager.core.CourseSearchCriteria;
import com.demo.student_manager.core.CourseWrapper;
import com.demo.student_manager.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class ClassController {
@Autowired
    ClassService classService;

    @PostMapping("/getCourses")
    public List<Course> getCourses(@RequestBody CourseWrapper courseWrapper){
        System.out.println(courseWrapper);
        return classService.getCourses(courseWrapper.getCoursePage(), courseWrapper.getCourseSearchCriteria());
    }

    @GetMapping("/getallcourses")
    public List<Course> getAllCourses(){
        return  classService.getAllCourses();
    }
}
