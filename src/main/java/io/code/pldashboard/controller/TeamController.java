package io.code.pldashboard.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.code.pldashboard.model.Match;
import io.code.pldashboard.model.Team;
import io.code.pldashboard.repository.MatchRepository;
import io.code.pldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
    

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
       
        Team team = this.teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));

        return team;
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year){
       
       
        String season = String.valueOf(year) + "-" + String.valueOf((year + 1) % 100);

        return this.matchRepository.getMatchesByTeamForSeason(
            teamName, season);

    }
    
}
