package io.code.pldashboard.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.code.pldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
    
    List<Match> getByHomeTeamOrAwayTeamOrderByDateDesc(String homeTeam, String awayTeam, Pageable pageable);

    @Query("select m from Match m where (m.homeTeam = :teamName or m.awayTeam = :teamName) and m.season = :season ")
    List<Match> getMatchesByTeamForSeason(
        @Param("teamName") String teamName, 
        @Param("season") String season
        );
    //interface allows a default method
    default List<Match> findLatestMatchesByTeam(String teamName, int count){
        return getByHomeTeamOrAwayTeamOrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
