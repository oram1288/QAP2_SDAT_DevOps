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
        return tournamentRepository.findById(tournamentId);
    }

    public Tournament findByTournyName(String tournamentName) {
        return tournamentRepository.findByTournyName(tournamentName);
    }

    public Optional<Tournament> getTournamentByLocation(String location) {
        return tournamentRepository.findByTournyLocation(location);
    }

    public Optional<Tournament> getTournamentByStartDate(Date startDate) {
        return tournamentRepository.findByTournyStartDate(startDate);
    }

    public List<Member> getMembersByTournament(Long tournamentId) {
        return tournamentRepository.findById(tournamentId)
                .map(Tournament::getMembers)
                .orElse(Collections.emptyList());
    }
}
