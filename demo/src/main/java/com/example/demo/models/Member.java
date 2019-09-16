package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://www.baeldung.com/jpa-many-to-many">https://www.baeldung.com/jpa-many-to-many</a>
 */
@Entity
@Table(name = "Member")
public class Member implements IsDbModel<Long>, Mergeable {

    @Id
    @GeneratedValue
    @NotNull(message = "id must not be null")
    private Long id;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @ManyToMany(mappedBy = "memberSet")
    @JsonIgnore
    private Set<Club> clubSet = new HashSet<>();

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

    public Set<Club> getClubSet() {
        return clubSet;
    }

    public void setClubSet(Set<Club> clubSet) {
        this.clubSet = clubSet;
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
