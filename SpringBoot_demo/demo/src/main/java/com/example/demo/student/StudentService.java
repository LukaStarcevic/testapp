package com.example.demo.student;
import com.example.demo.core.ErrorResponse;
import com.example.demo.core.Response;
import com.example.demo.exeption.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
  private final StudentDataSource dataSource;
  @Autowired
  StudentService(StudentDataSource dataSource){
      this.dataSource = dataSource;
  }

  public Response getStudent(Integer id) {

      try {
          final Student temp;
        temp = dataSource.getData(id);
          return  temp;
      }
      catch (Exception e){

          if (e instanceof DataException){
              return new ErrorResponse("User not fount");
          }
      }
     return null;
  }

  public void addStudent(Student student){
      dataSource.addStudent(student);
  }

public List<Student> getStudents(){
      return dataSource.getStudents();
}

}
