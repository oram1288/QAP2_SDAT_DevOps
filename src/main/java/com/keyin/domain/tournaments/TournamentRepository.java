package com.keyin.domain.tournaments;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long>  {

    public Tournament findByTournamentName(String tournamentName);

    Optional<Tournament> findByTournamentId(Long tournamentId);

    Optional<Tournament> findByStartDate(String startDate);

    Optional<Tournament> findByLocation(String location);
}
