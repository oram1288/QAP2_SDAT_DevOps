package com.keyin.domain.members;

import com.keyin.domain.tournaments.Tournament;
import jakarta.persistence.*;

import java.util.ArrayList;
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
    private Date membershipStartDate;
    private String membershipDuration;

    @ManyToOne
    private Tournament tournamentName;

    public Member () {

    }

    public Member(Long memberId, String memberName, String address, String email, String phoneNumber, String membershipType, Date membershipStartDate, String membershipDuration, Tournament tournamentName) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipType = membershipType;
        this.membershipStartDate = membershipStartDate;
        this.membershipDuration = membershipDuration;
        this.tournamentName = tournamentName;
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

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public String getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(String membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

//    public List<Tournament> getTournament() {
//        return tournament;
//    }
//
//    public void setTournament(List<Tournament> tournament) {
//        this.tournament = tournament;
//    }

    public Tournament getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(Tournament tournamentName) {
        this.tournamentName = tournamentName;
    }
}
