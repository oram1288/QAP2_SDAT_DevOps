package com.keyin.domain.members;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String memberName;
    private String address;
    private String email;
    private String phoneNumber;
    private Date membershipStartDate;
    private String membershipDuration;

    public Member () {

    }

    public Member(Long memberId, String memberName, String address, String email, String phoneNumber, Date membershipStartDate, String membershipDuration) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipStartDate = membershipStartDate;
        this.membershipDuration = membershipDuration;
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
}
