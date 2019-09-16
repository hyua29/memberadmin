package com.example.demo.controllers;

import com.example.demo.models.Club;
import com.example.demo.models.Member;
import com.example.demo.repos.ClubRepository;
import com.example.demo.repos.MemberRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    private MemberRepository memberRepository;
    private ClubRepository clubRepository;

    @Autowired
    public MembershipController(MemberRepository memberRepository, ClubRepository clubRepository) {
        this.memberRepository = memberRepository;
        this.clubRepository = clubRepository;
    }

    @PostMapping("/")
    public ResponseEntity<String> addMembership(
            @ApiParam(value = "Member ID", required = true) @Valid @RequestBody MembershipRequestBody requestBody) {
//        if (!requestBody.isValidIds()) return ResponseEntity.badRequest().build();
        Optional<Member> memberO = memberRepository.findById(requestBody.getMember_id());
        Optional<Club> clubO = clubRepository.findById(requestBody.getClub_id());

        if (!clubO.isPresent() || !memberO.isPresent()) return ResponseEntity.notFound().build();

        Club c = clubO.get();
        c.getMemberSet().add(memberO.get()); // Added membership
        clubRepository.save(c);

        return ResponseEntity.ok("Membership updated");
    }

    @DeleteMapping("/")
    public ResponseEntity<String> removeMembership(
            @ApiParam(value = "Member ID", required = true) @Valid @RequestBody MembershipRequestBody requestBody) {
//        if (!requestBody.isValidIds()) return ResponseEntity.badRequest().build();
        Optional<Club> clubO = clubRepository.findById(requestBody.getClub_id());
        Optional<Member> memberO = memberRepository.findById(requestBody.getMember_id());

        if (!clubO.isPresent() || !memberO.isPresent()) return ResponseEntity.notFound().build();

        Club c = clubO.get();
        c.getMemberSet().remove(memberO.get()); // remove membership
        clubRepository.save(c);

        return ResponseEntity.ok("Membership deleted");
    }
}