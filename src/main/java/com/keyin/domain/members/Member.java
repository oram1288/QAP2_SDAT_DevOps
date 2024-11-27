package com.keyin.domain.members;

import com.keyin.domain.tournaments.Tournament;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String memberName;
    private String address;
    private String email;
    private String phoneNumber;
    private String membershipType;
    private String membershipStartDate;
    private String membershipDuration;

    @OneToMany
    private List <Tournament> tournaments;

    public Member () {

    }

    public Member(Long memberId, String memberName, String address, String email, String phoneNumber, String membershipType, String membershipStartDate, String membershipDuration, List <Tournament> tournaments) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipType = membershipType;
        this.membershipStartDate = membershipStartDate;
        this.membershipDuration = membershipDuration;
        this.tournaments = tournaments;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(String membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public String getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(String membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
}
