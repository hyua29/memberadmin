//package com.example.demo.models.membership;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class MembershipKey implements Serializable {
//    @Column(name = "club_id")
//    private Long clubId;
//
//    @Column(name = "member_id")
//    private Long memberId;
//
//    public Long getClubId() {
//        return clubId;
//    }
//
//    public void setClubId(Long clubId) {
//        this.clubId = clubId;
//    }
//
//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof MembershipKey)) return false;
//        MembershipKey that = (MembershipKey) o;
//        return Objects.equals(getClubId(), that.getClubId()) &&
//                Objects.equals(getMemberId(), that.getMemberId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getClubId(), getMemberId());
//    }
//}
