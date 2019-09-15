package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Club")
public class Club implements IsDbModel<Long>, Mergeable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    public Club() {
    }

    public Club(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void mergeWith(Object src) {
        assert !(src instanceof Club): "Cannot merge objects of different classes";

        Club srcClub = (Club) src;
        if (srcClub.name != null) this.name = srcClub.name;
    }
}
