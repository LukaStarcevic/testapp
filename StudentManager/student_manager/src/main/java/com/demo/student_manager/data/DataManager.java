package com.demo.student_manager.data;

import com.demo.student_manager.core.Course;
import com.demo.student_manager.core.CoursePage;
import com.demo.student_manager.core.CourseSearchCriteria;
import com.demo.student_manager.core.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.List.of;

@Component
@Repository
public class DataManager {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;



    @Autowired
    StudentInterface studentInterface;
    @Autowired
    ClassInterface classInterface;
   public DataManager(EntityManager entityManager, StudentInterface studentInterface){
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
        this.studentInterface = studentInterface;
    }

    public Page<Student> getStudentPage(Pageable pageable){
        return studentInterface.findAll(pageable);
    }

    public List<Course> getCourse(CoursePage coursePage, CourseSearchCriteria courseSearchCriteria){
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = criteriaQuery.from(Course.class);
        Predicate predicate = getPredicate(courseSearchCriteria,courseRoot);
        criteriaQuery.where(predicate);
        setOrder(coursePage,criteriaQuery,courseRoot);
        TypedQuery<Course> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(coursePage.getPageNumber() * coursePage.getPageSize());
        typedQuery.setMaxResults(coursePage.getPageSize());

      //  Pageable pageable = getPageable(coursePage);

        long employeesCount = getCourseCount(predicate);

        return  typedQuery.getResultList();
    }

    public List<Course> getAllCourses(){
       List<Course> courses = new  ArrayList<Course>();

       classInterface.findAll().forEach(course -> courses.add(course));
       return  courses;

    }


    private Predicate getPredicate(CourseSearchCriteria courseSearchCriteria, Root<Course> courseRoot) {
       List<Predicate> predicates = new ArrayList<>();
        if(!courseSearchCriteria.getCourse().isEmpty() && !courseSearchCriteria.getCourse().isBlank()){
            predicates.add(
                    criteriaBuilder.like(courseRoot.get("courseName"),
                            "%" + courseSearchCriteria.getCourse() + "%")
            );
        }
        if(courseSearchCriteria.getGrade() != -1){
            predicates.add(
                    criteriaBuilder.equal(courseRoot.get("grade"),courseSearchCriteria.getGrade())
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(CoursePage coursePage,
                          CriteriaQuery<Course> criteriaQuery,
                          Root<Course> courseRoot) {
        if(coursePage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(courseRoot.get(coursePage.getSortby())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(courseRoot.get(coursePage.getSortby())));
        }
    }

   /* private Pageable getPageable(CoursePage coursePage) {
        Sort sort = Sort.by(coursePage.getSortDirection(), coursePage.getSortby());
        return PageRequest.of(coursePage.getPageNumber(),coursePage.getPageSize(), sort);
    }*/

    private long getCourseCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Course> countRoot = countQuery.from(Course.class);
       countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        //return entityManager.createQuery(countQuery).getSingleResult();
        return 12;
    }

}
