package com.example.demo.student;
import com.example.demo.core.ErrorResponse;
import com.example.demo.core.Response;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final  StudentService stService;
    @Autowired
    StudentController(StudentService service){
        this.stService = service;
    }

    @GetMapping("/{id}")
    public Response getStudent(@PathVariable Integer id, HttpServletResponse response){

        final Response tempResp = stService.getStudent(id);

        if (tempResp instanceof ErrorResponse) {
            response.setStatus(404);
        } else {
            response.setStatus(200);
        }
        return tempResp;

    }
    @PostMapping("addStudent")
    public void addStudent(@RequestBody @Valid Student student){
       stService.addStudent(student);

    }

    @GetMapping
    public List<Student> getStudents(){
        return stService.getStudents();
    }



}


