package com.example.demo.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

class MembershipRequestBody {
    @JsonProperty(required = true)
    @NotNull(message = "message_id must not be null")
    private Long member_id;

    @JsonProperty(required = true)
    @NotNull(message = "club_id must not be null")
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

    boolean isValidIds() {
        return this.getClub_id() != null && this.getMember_id() != null;
    }
}