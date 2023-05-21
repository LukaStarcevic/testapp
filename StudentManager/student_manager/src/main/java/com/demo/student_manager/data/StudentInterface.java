package com.demo.student_manager.data;

import com.demo.student_manager.core.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInterface extends PagingAndSortingRepository<Student,Integer> {
}
