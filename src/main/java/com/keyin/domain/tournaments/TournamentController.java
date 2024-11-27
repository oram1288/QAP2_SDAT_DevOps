package com.keyin.domain.tournaments;

import com.keyin.domain.members.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/addNewTournament")
    public Tournament addNewTournament(@RequestBody Tournament tournament) {

        return tournamentService.addTournament(tournament);
    }

    @GetMapping("/listAllTournaments")
    public ResponseEntity<Iterable<Tournament>> getAllTournaments() {
        tournamentService.getAllTournaments();
        return ResponseEntity.ok().body(tournamentService.getAllTournaments());
    }

    @GetMapping("/getTournamentById/{tournamentId}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long tournamentId) {
        Optional<Tournament> tournament = tournamentService.getTournamentById(tournamentId);
        return tournament.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getTournamentByStartDate/{startDate}")
    public ResponseEntity<Tournament> getTournamentByStartDate(@PathVariable String startDate) {
        Optional<Tournament> tournament = tournamentService.getTournamentByStartDate(startDate);
        return tournament.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getTournamentByLocation/{location}")
    public ResponseEntity<Tournament> getTournamentByLocation(@PathVariable String location) {
        Optional<Tournament> tournament = tournamentService.getTournamentByLocation(location);
        return tournament.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteTournamentById/{tournamentId}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long tournamentId) {
        if (tournamentService.deleteTournament(tournamentId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

//    @GetMapping("/getMembersInTournament{tournamentId}")
//    public ResponseEntity<List<Member>> getMembersByTournament(@PathVariable Long tournamentId) {
//        List<Member> members = tournamentService.getMembersByTournament(tournamentId);
//        if (members.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(members);
//    }
}
