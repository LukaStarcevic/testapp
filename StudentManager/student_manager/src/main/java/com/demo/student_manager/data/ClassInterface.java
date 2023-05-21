package com.demo.student_manager.data;

import com.demo.student_manager.core.Course;
import org.springframework.data.repository.CrudRepository;

public interface ClassInterface extends CrudRepository<Course,Long> {
}
