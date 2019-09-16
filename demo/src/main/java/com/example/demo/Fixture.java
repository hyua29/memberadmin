package com.example.demo;

import com.example.demo.models.Club;
import com.example.demo.models.Member;
//import com.example.demo.models.membership.Membership;
import com.example.demo.repos.ClubRepository;
import com.example.demo.repos.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Initialize database using JPA.
 * Database should only be initialized once.
 */
@Component
public class Fixture {
    private boolean isDbInitialized = false;

    private MemberRepository memberRepository;
    private ClubRepository clubRepository;

    @Autowired
    private Fixture(MemberRepository memberRepository, ClubRepository clubRepository) {
        this.memberRepository = memberRepository;
        this.clubRepository = clubRepository;
    }

    public boolean isDbInitialized() {
        return isDbInitialized;
    }

    public boolean initDb () {
        if (this.isDbInitialized) return false;

        /* init a list of members */
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("Aaron", "Hank"));
        memberList.add(new Member("Bachelard", "Gaston"));
        memberList.add(new Member("Crimmins", "Barry"));
        memberRepository.saveAll(memberList);

        /* init a list of clubs */
        List<Club> clubList = new ArrayList<>();
        clubList.add(new Club("Club A"));
        clubList.add(new Club("Club C"));
        clubRepository.saveAll(clubList);

        /* first member will join the first club */
        Club c = clubList.get(0);
        c.getMemberSet().add(memberList.get(0));
        c.getMemberSet().add(memberList.get(0));
        clubRepository.save(c);
        this.isDbInitialized = true;
        return true;
    }
}
