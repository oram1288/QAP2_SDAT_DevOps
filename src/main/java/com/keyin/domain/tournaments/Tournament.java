package com.keyin.domain.tournaments;

import com.keyin.domain.members.Member;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentId;

    private String tournamentName;
    private String startDate;
    private String endDate;
    private String location;
    private String entryFee;
    private String cashPrizeAmount;

    @ManyToMany
    private List<Member> members = new ArrayList<>();

    public Tournament() {

    }

    public Tournament(Long tournamentId, String tournamentName, String startDate, String endDate, String location, String entryFee, String cashPrizeAmount, List<Member> members) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrizeAmount = cashPrizeAmount;
        this.members = members;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public String getCashPrizeAmount() {
        return cashPrizeAmount;
    }

    public void setCashPrizeAmount(String cashPrizeAmount) {
        this.cashPrizeAmount = cashPrizeAmount;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
