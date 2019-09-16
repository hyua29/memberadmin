package com.example.demo.controllers;

class MembershipRequestBody {
    private Long member_id;
    private Long club_id;

    Long getMember_id() {
        return member_id;
    }

    void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    Long getClub_id() {
        return club_id;
    }

    void setClub_id(Long club_id) {
        this.club_id = club_id;
    }
}