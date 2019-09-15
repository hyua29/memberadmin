package com.example.demo.models;

/**
 * Provide an interface to access model id
 * @param <T> Type of id e.g. String, Integer, Long
 */
public interface IsDbModel<T> {
    T getId();

    void setId(T id);
}
