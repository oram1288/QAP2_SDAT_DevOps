package com.keyin.domain.tournaments;

import com.keyin.domain.members.Member;
import com.keyin.domain.members.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Iterable<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long tournamentId) {
        return tournamentRepository.findByTournamentId(tournamentId);
    }

    public Optional<Tournament> findByTournamentId(Long tournamentId) {
        return tournamentRepository.findByTournamentId(tournamentId);

    }

    public Tournament findByTournamentName(String tournamentName) {
        return tournamentRepository.findByTournamentName(tournamentName);

    }

    public Optional<Tournament> getTournamentByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    public Optional<Tournament> getTournamentByStartDate(String startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public boolean deleteTournament(Long tournamentId) {
        if (tournamentRepository.existsById(tournamentId)) {
            tournamentRepository.deleteById(tournamentId);
        } else {
            throw new RuntimeException("City not found with id " + tournamentId);
        }
        return false;
    }

//    public List<Member> getMembersByTournamentName(String tournamentName) {
//        return tournamentRepository.(tournamentName)
//                .map(Tournament::getMember)
//                .orElse(Collections.emptyList());
//    }
}
