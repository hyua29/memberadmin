package com.example.demo.models;

public interface IsDbModel<T> {
    T getId();
    void setId(T id);

    void mergeWith(Object src);
}
