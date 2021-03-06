package io.code.pldashboard.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String teamName;
    private long totalMatches;
    private long totalWins;
    private long totalDraws;
    private String stadium;

    @Transient
    private List<Match> matches;

    
    public Team(String teamName, long totalMatches) {
        this.teamName = teamName;
        this.totalMatches = totalMatches;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public long getTotalMatches() {
        return totalMatches;
    }
    public void setTotalMatches(long totalMatches) {
        this.totalMatches = totalMatches;
    }
    public long getTotalWins() {
        return totalWins;
    }
    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    
    public long getTotalDraws() {
        return totalDraws;
    }
    public void setTotalDraws(long totalDraws) {
        this.totalDraws = totalDraws;
    }
    
    public Team() {
    }
    public List<Match> getMatches() {
        return matches;
    }
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
    public String getStadium() {
        return stadium;
    }
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        return "Team [matches=" + matches + ", teamName=" + teamName + ", totalDraws=" + 
        totalDraws + ", totalMatches="
                + totalMatches + ", totalWins=" + totalWins + ", stadium=" + stadium + "]";
    }
    
    
}
