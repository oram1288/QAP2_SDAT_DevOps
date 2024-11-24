package com.keyin.domain.members;

import com.keyin.domain.tournaments.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Member> getMemberByMembership(String membershipType) {
        return memberRepository.findMemberByMembershipType(membershipType);
    }

    public Optional<Member> getMemberByPhoneNumber(String phoneNumber) {
        return memberRepository.findMemberByPhoneNumber(phoneNumber);
    }

//    public Iterable<Member> getMemberByTournyId(Long tournamentId) {
//        if (tournamentRepository.existsById(tournamentId)) {
//            return memberRepository.findMemberByTournyName(tournamentId);
//        }
//        return List.of();
//    }
}
