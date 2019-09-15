package com.example.demo.models;

interface IsDbModel<T> {
    T getId();

    void setId(T id);
}
