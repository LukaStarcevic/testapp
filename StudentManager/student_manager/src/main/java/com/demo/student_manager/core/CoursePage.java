package com.demo.student_manager.core;

import org.springframework.data.domain.Sort;

public class CoursePage {
    private int pageNumber=0;
    private int pageSize = 25;
    private Sort.Direction sortDirection= Sort.Direction.ASC;
    private String sortby = "studentName";

    public CoursePage(int pageNumber,int pageSize,int direction,String sortby){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortDirection = direction == 0 ? Sort.Direction.DESC : Sort.Direction.ASC;
        this.sortby = sortby;
    }


    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getSortby() {
        return sortby;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortby(String sortby) {
        this.sortby = sortby;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public String toString() {
        return "CoursePage{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", sortDirection=" + sortDirection +
                ", sortby='" + sortby + '\'' +
                '}';
    }
}
