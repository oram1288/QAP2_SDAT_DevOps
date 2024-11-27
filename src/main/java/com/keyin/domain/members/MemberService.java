package com.keyin.domain.members;

import com.keyin.domain.tournaments.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Optional<Member> getMemberByName(String memberName) {
        return memberRepository.findMemberByMemberName(memberName);
    }

    public Optional<List<Member>> getMemberByMembership(String membershipType) {
        return memberRepository.findMemberByMembershipType(membershipType);
    }

    public Optional<Member> getMemberByPhoneNumber(String phoneNumber) {
        return memberRepository.findMemberByPhoneNumber(phoneNumber);
    }

    public boolean deleteMember(Long memberId) {
        if (memberRepository.existsById(memberId)) {
            memberRepository.deleteById(memberId);
        } else {
            throw new RuntimeException("City not found with id " + memberId);
        }
        return false;
    }

    public Optional<List<Member>> getMemberByTournamentName(String tournamentName) {
        return memberRepository.findMemberByTournaments_TournamentName(tournamentName);
    }

    public Optional<List<Member>> getMemberByTournamentStartDate(String startDate) {
        return memberRepository.findMemberByTournaments_StartDate(startDate);
    }

}
