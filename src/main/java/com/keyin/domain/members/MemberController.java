package com.keyin.domain.members;

import com.keyin.domain.tournaments.Tournament;
import com.keyin.domain.tournaments.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/addNewMember")
    public Member addNewMember(@RequestBody Member member) {

        Optional<Tournament> tournamentOptional = Optional.ofNullable(tournamentService.findByTournyName(member.getTournamentName().getTournamentName()));

        Tournament tournament;
        if (tournamentOptional.isPresent()) {
            tournament = tournamentOptional.get();
        } else {
            // Save the new member if it doesn't exist
            tournament = member.getTournamentName();
            tournamentService.addTournament(tournament);
        }

        member.setTournamentName(tournament);

        return memberService.addMember(member);
    }

    @GetMapping("/listAllMembers")
    public ResponseEntity<Iterable<Member>> getAllMembers() {
        memberService.getAllMembers();
        return ResponseEntity.ok().body(memberService.getAllMembers());
    }

    @GetMapping("/getMemberById/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long memberId) {
        Optional<Member> member = memberService.getMemberById(memberId);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getMemberByName/{memberName}")
    public ResponseEntity<Member> getMemberByName(@PathVariable String memberName) {
        Optional<Member> member = memberService.getMemberByName(memberName);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getMemberByMembership/{membershipType}")
    public ResponseEntity<Member> getMemberByMembershipType(@PathVariable String membershipType) {
        Optional<Member> member = memberService.getMemberByMembership(membershipType);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getMemberPhoneNumber/{phoneNumber}")
    public ResponseEntity<Member> getMemberByPhoneNumber(@PathVariable String phoneNumber) {
        Optional<Member> member = memberService.getMemberByPhoneNumber(phoneNumber);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @GetMapping("/getMemberByTournyId/{tournamentId}")
//    public ResponseEntity<Iterable<Member>> getMemberByTournyId(@PathVariable Long tournamentId) {
//        Iterable<Member> members = memberService.getMemberByTournyId(tournamentId);
//        if (members.iterator().hasNext()) {
//            return ResponseEntity.ok(members);
//        }
//        return ResponseEntity.notFound().build();
//    }
}
