package io.code.pldashboard.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;


import io.code.pldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        
        Match match = new Match();

        match.setId(Long.parseLong(matchInput.getId()));
        match.setSeason(matchInput.getSeason());
        

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(matchInput.getDate(), formatter);
                
        match.setDate(date);
        match.setHomeTeam(matchInput.getHomeTeam());
        match.setAwayTeam(matchInput.getAwayTeam());
        match.setFullTimeHomeGoals(Integer.parseInt(matchInput.getFullTimeHomeGoals()));
        match.setFullTimeAwayGoals(Integer.parseInt(matchInput.getFullTimeAwayGoals()));

        if("NA".equals(matchInput.getReferee())){
            match.setReferee("Not Available");
        } else{
            match.setReferee(matchInput.getReferee());
        }
       

        String winner;

        if("H".equals(matchInput.getResult())){
           winner = matchInput.getHomeTeam();
        } else if("A".equals(matchInput.getResult())){
           winner = matchInput.getAwayTeam();
        } else{
            winner = "DRAW";
        }

        match.setResult(winner);

        return match;

    }

}

