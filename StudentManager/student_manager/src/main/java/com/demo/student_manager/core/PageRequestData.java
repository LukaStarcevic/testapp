package com.demo.student_manager.core;

import org.springframework.data.domain.Sort;

import java.util.List;

public class PageRequestData {

    private int page;
    private int size;

    private String sortParam;

    private  int direction;


    public PageRequestData(){}

    public PageRequestData(int page,int size,String  sortParam,int direction){
        this.page = page;
        this.size =size;
        this.sortParam = sortParam;
        this.direction = direction;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getDirection() {
        return direction;
    }

    public String getsortParam() {
        return sortParam;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSortParam(String sortParam) {
        this.sortParam = sortParam;
    }

    @Override
    public String toString() {
        return "PageRequestData{" +
                "page=" + page +
                ", size=" + size +
                ", sortParam=" + sortParam +
                ", direction=" + direction +
                '}';
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
