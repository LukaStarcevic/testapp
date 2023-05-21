package com.demo.student_manager.core;

import jakarta.annotation.Nullable;

public class CourseSearchCriteria {
    @Nullable
    private int grade;
    @Nullable
    private String course;


    public CourseSearchCriteria(int grade,String course){
        this.grade = grade == 0 ? -1 : grade;
        this.course =course == null || course.isEmpty() || course.isBlank()  ? "" : course;

    }

    public int getGrade() {
        return grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseSearchCriteria{" +
                "grade=" + grade +
                ", course='" + course + '\'' +
                '}';
    }
}
