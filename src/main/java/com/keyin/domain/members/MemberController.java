package com.keyin.domain.members;

import com.keyin.domain.tournaments.Tournament;
import com.keyin.domain.tournaments.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TournamentService tournamentService;

//    @PostMapping("/addNewMember")
//    public Member addNewMember(@RequestBody Member member) {
//
//        List<Tournament> updatedTournamentList = new ArrayList<>();
//        for (Tournament tournament : member.getTournaments()) {
//            Optional<Tournament> tournamentOptional = Optional.ofNullable(tournamentService.findByTournamentName(tournament.getTournamentName()));
//            if (tournamentOptional.isPresent()) {
//                tournament = tournamentOptional.get();
//                updatedTournamentList.add(tournament);
//            } else {
//
//                updatedTournamentList = member.getTournaments();
//                tournamentService.addTournament(tournament);
//            }
//
//        }
//        member.setTournaments(updatedTournamentList);
//        return memberService.addMember(member);
//
//    }

    @PostMapping("/addNewMember")
    public Member addNewMember(@RequestBody Member member) {
        List<Tournament> updatedTournamentList = new ArrayList<>();

        for (Tournament tournament : member.getTournaments()) {
            Optional<Tournament> tournamentOptional = Optional.ofNullable(tournamentService.findByTournamentName(tournament.getTournamentName()));

            if (tournamentOptional.isPresent()) {
                // If tournament exists, use the existing tournament
                Tournament existingTournament = tournamentOptional.get();
                updatedTournamentList.add(existingTournament);
            } else {
                // If tournament does not exist, add the new tournament
                updatedTournamentList.add(tournamentService.addTournament(tournament));
            }
        }

        // Set the updated list of tournaments to the member
        member.setTournaments(updatedTournamentList);

        // Save the member and return
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
    public ResponseEntity<List<Member>> getMemberByMembership(@PathVariable String membershipType) {
        Optional<List<Member>> member = memberService.getMemberByMembership(membershipType);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getMemberPhoneNumber/{phoneNumber}")
    public ResponseEntity<Member> getMemberByPhoneNumber(@PathVariable String phoneNumber) {
        Optional<Member> member = memberService.getMemberByPhoneNumber(phoneNumber);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteMemberById/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        if (memberService.deleteMember(memberId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getMembersByTournamentName/{tournamentName}")
    public ResponseEntity<Optional<List<Member>>> getMemberByTournamentName(@PathVariable String tournamentName) {
        Optional<List<Member>> members = memberService.getMemberByTournamentName(tournamentName);
        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(members);
    }

    @GetMapping("/getMembersByTournamentStartDate/{startDate}")
    public ResponseEntity<Optional<List<Member>>> getMemberByTournamentStartDate(@PathVariable String startDate) {
        Optional<List<Member>> members = memberService.getMemberByTournamentStartDate(startDate);
        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(members);
    }
}
