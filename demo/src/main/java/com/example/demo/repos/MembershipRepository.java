package com.example.demo.repos;

import com.example.demo.models.Club;
import org.springframework.data.repository.CrudRepository;

public interface MembershipRepository extends CrudRepository<Club, Long> {
}
