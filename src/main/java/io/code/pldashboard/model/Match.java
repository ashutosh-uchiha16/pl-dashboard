package io.code.pldashboard.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {
    
    @Id
    private long id;

    private String season;
    private LocalDate date;
    private String homeTeam;
    private String awayTeam;
    private int fullTimeHomeGoals;
    private int fullTimeAwayGoals;
    private String result;
    private String referee;
    private String stadium;

    
    public Match() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
    public int getFullTimeHomeGoals() {
        return fullTimeHomeGoals;
    }
    public void setFullTimeHomeGoals(int fullTimeHomeGoals) {
        this.fullTimeHomeGoals = fullTimeHomeGoals;
    }
    public int getFullTimeAwayGoals() {
        return fullTimeAwayGoals;
    }
    public void setFullTimeAwayGoals(int fullTimeAwayGoals) {
        this.fullTimeAwayGoals = fullTimeAwayGoals;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getReferee() {
        return referee;
    }
    public void setReferee(String referee) {
        this.referee = referee;
    }
    public String getStadium() {
        return stadium;
    }
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
    
    @Override
    public String toString() {
        return "Match [awayTeam=" + awayTeam + ", date=" + date + ", fullTimeAwayGoals=" + fullTimeAwayGoals
                + ", fullTimeHomeGoals=" + fullTimeHomeGoals + ", homeTeam=" + homeTeam + ", id=" + id + ", referee="
                + referee + ", result=" + result + ", season=" + season + ", stadium=" + stadium + "]";
    }

    
    
}
