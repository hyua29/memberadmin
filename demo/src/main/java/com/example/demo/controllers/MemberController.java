package com.example.demo.controllers;


import com.example.demo.models.Member;
import com.example.demo.repos.MemberRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/members")
public class MemberController extends BaseRestController<Member, MemberRepository, Long> {

    @Autowired
    public MemberController(MemberRepository repo) {
        super(repo);
    }
}
