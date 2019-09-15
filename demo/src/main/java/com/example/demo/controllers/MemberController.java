package com.example.demo.controllers;


import com.example.demo.models.Member;
import com.example.demo.repos.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.EntityResponse;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/members")
public class MemberController extends BaseRestController<Member, MemberRepository, Long> {

    @Autowired
    public MemberController(MemberRepository repo) {
        super(repo);
    }

}
