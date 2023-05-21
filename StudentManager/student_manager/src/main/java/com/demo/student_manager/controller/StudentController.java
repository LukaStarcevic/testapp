package com.demo.student_manager.controller;

import com.demo.student_manager.core.PageRequestData;
import com.demo.student_manager.core.Student;
import com.demo.student_manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {

    private StudentService studentService;
    @Autowired
public  StudentController(StudentService studentService){
    this.studentService = studentService;
}


@PostMapping("/student/getpage")
    Page<Student> getStudentPage(@RequestBody PageRequestData pageable){
    System.out.println(pageable.toString());
        Sort sort = Sort.by(pageable.getDirection() == 0 ? Sort.Direction.ASC : Sort.Direction.DESC,pageable.getsortParam());


    Pageable pageable1 = PageRequest.of(pageable.getPage(), pageable.getSize(),sort);

        return  studentService.getPage(pageable1);
    }


}
