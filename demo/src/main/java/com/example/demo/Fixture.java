package com.example.demo;

import com.example.demo.models.Member;
import com.example.demo.repos.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Fixture {

    private boolean isDbInitialized = false;

    private MemberRepository memberRepository;

    @Autowired
    private Fixture(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean initDb () {
        if (this.isDbInitialized) return false;

        /* init a list of members */
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("Aaron", "Hank"));
        memberList.add(new Member("Bachelard", "Gaston"));
        memberList.add(new Member("Crimmins", "Barry"));
        memberRepository.saveAll(memberList);


        this.isDbInitialized = true;
        return true;
    }
}
