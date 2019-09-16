//package com.example.demo.models.membership;
//
//import com.example.demo.models.Club;
//import com.example.demo.models.Member;
//
//import javax.persistence.*;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//
//@Entity
//@Table(name = "Membership")
//public class Membership {
//    @EmbeddedId
//    private MembershipKey key;
//
//    @ManyToOne
//    @MapsId("member_id") // references the id in MembershipKey
//    @JoinColumn(name = "id")
//    private Member member;
//
//    @ManyToOne
//    @MapsId("club_id")
//    @JoinColumn(name = "id")
//    private Club club;
//
//    @Column(name = "start_date")
//    @Temporal(TemporalType.DATE)
//    private Date startDate = new Date();
//
//    @Column(name = "expiry_date")
//    @Temporal(TemporalType.DATE)
//    private Date expiryDate = this.calculateExpiryDate();
//
//    public Membership() {
//    }
//
//    public Membership(Member member, Club club) {
//        this.member = member;
//        this.club = club;
//    }
//
//    /**
//     * Membership expires in 100 days
//     * @return Expiry date
//     */
//    private Date calculateExpiryDate() {
//        Calendar c = new GregorianCalendar();
//        c.add(Calendar.DATE, 30);
//        return c.getTime();
//    }
//    public MembershipKey getKey() {
//        return key;
//    }
//
//    public void setKey(MembershipKey key) {
//        this.key = key;
//    }
//
//    public Member getMember() {
//        return member;
//    }
//
//    public void setMember(Member member) {
//        this.member = member;
//    }
//
//    public Club getClub() {
//        return club;
//    }
//
//    public void setClub(Club club) {
//        this.club = club;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getExpiryDate() {
//        return expiryDate;
//    }
//
//    public void setExpiryDate(Date expiryDate) {
//        this.expiryDate = expiryDate;
//    }
//}
