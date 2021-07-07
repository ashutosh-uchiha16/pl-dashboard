package io.code.pldashboard.data;

public class MatchInput {
    
    private String id;
    private String season;
    private String date;
    private String homeTeam;
    private String awayTeam;
    private String fullTimeHomeGoals;
    private String fullTimeAwayGoals;
    private String result;
    private String referee;


    
    public MatchInput() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
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
    public String getFullTimeHomeGoals() {
        return fullTimeHomeGoals;
    }
    public void setFullTimeHomeGoals(String fullTimeHomeGoals) {
        this.fullTimeHomeGoals = fullTimeHomeGoals;
    }
    public String getFullTimeAwayGoals() {
        return fullTimeAwayGoals;
    }
    public void setFullTimeAwayGoals(String fullTimeAwayGoals) {
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

   

    

}
