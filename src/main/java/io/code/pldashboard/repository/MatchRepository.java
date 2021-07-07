package io.code.pldashboard.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import io.code.pldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
    
    List<Match> getByHomeTeamOrAwayTeamOrderByDateDesc(String homeTeam, String awayTeam, Pageable pageable);

    //interface allows a default method
    default List<Match> findLatestMatchesByTeam(String teamName, int count){
        return getByHomeTeamOrAwayTeamOrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
