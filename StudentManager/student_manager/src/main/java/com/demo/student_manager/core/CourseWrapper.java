package com.demo.student_manager.core;

public class CourseWrapper {
    private CoursePage coursePage;
    private CourseSearchCriteria courseSearchCriteria;

    public CourseWrapper(){}
    public CourseWrapper(CoursePage coursePage,CourseSearchCriteria courseSearchCriteria){
        this.coursePage = coursePage;
        this.courseSearchCriteria = courseSearchCriteria;
    }
    public CoursePage getCoursePage() {
        return coursePage;
    }

    public CourseSearchCriteria getCourseSearchCriteria() {
        return courseSearchCriteria;
    }

    public void setCoursePage(CoursePage coursePage) {
        this.coursePage = coursePage;
    }

    public void setCourseSearchCriteria(CourseSearchCriteria courseSearchCriteria) {
        this.courseSearchCriteria = courseSearchCriteria;
    }

    @Override
    public String toString() {
        return "CourseWrapper{" +
                "coursePage=" + coursePage +
                ", courseSearchCriteria=" + courseSearchCriteria +
                '}';
    }
}
