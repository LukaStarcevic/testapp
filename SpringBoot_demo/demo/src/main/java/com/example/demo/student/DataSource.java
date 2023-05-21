package com.example.demo.student;

public abstract class DataSource<T,M> {
    abstract public T getData(M id)throws Exception;
}
