package com.example.demo.repos;

import com.example.demo.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

}
