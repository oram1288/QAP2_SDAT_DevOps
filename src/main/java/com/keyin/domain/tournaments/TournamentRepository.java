package com.keyin.domain.tournaments;

import com.keyin.domain.members.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long>  {

    public Tournament findByTournyName(String tournamentName);

    Optional<Tournament> findByTournyStartDate(Date startDate);

    Optional<Tournament> findByTournyLocation(String location);
}
