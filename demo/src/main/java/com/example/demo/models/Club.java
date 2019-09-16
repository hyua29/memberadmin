package com.example.demo.models;

//import com.example.demo.models.membership.Membership;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Club")
public class Club implements IsDbModel<Long>, Mergeable {
    @Id
    @GeneratedValue
    @ApiModelProperty(example = "0")
    private Long id;

    @ApiModelProperty(example = "Club A")
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "Membership",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "club_id"))
    private Set<Member> memberSet = new HashSet<>();

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

    public Set<Member> getMemberSet() {
        return memberSet;
    }

    public void setMemberSet(Set<Member> memberSet) {
        this.memberSet = memberSet;
    }

    @Override
    public void mergeWith(Object src) {
        assert !(src instanceof Club): "Cannot merge objects of different classes";

        Club srcClub = (Club) src;
        if (srcClub.name != null) this.name = srcClub.name;
    }
}
