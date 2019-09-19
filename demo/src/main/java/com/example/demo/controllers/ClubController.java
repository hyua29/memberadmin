package com.example.demo.controllers;

import com.example.demo.models.Club;
import com.example.demo.repos.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clubs")
public class ClubController extends BaseRestController<Club, ClubRepository, Long>{
    @Autowired
    public ClubController(ClubRepository repo) {
        super(repo);
    }

}
