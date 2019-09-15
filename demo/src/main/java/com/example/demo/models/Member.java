package com.example.demo.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "Member")
public class Member implements IsDbModel<Long>, Mergeable {

    @Id
    @GeneratedValue
    @ApiModelProperty(example = "0")
    private Long id;

    @ApiModelProperty(example = "Aaron")
    @Column(name = "first_name", length = 100)
    private String firstName;

    @ApiModelProperty(example = "Hank")
    @Column(name = "last_name", length = 100)
    private String lastName;

    public Member() {
    }

    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void mergeWith(Object src) {
        assert !(src instanceof Member): "Cannot merge objects of different classes";

        Member srcMember = (Member) src;
        if (srcMember.firstName != null) this.firstName = srcMember.firstName;
        if (srcMember.lastName != null) this.lastName = srcMember.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
