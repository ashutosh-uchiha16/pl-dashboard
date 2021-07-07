package io.code.pldashboard.data;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.TransactionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.code.pldashboard.model.Team;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final EntityManager em;

  @Autowired
  public JobCompletionNotificationListener(EntityManager em) {
    this.em = em;
  }

  // private final JdbcTemplate jdbcTemplate;

  // @Autowired
  // public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
  //   this.jdbcTemplate = jdbcTemplate;
  // }

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

      // jdbcTemplate.query("SELECT season, date, home_team, away_team, full_time_home_goals,full_time_away_goals, result,referee FROM match",
      //   (rs, row) -> 
      //               // " Id: " + rs.getString(1) + 
      //               " season: " + rs.getString(1) + 
      //               " date: " + rs.getString(2) + 
      //               " homeTeam: " + rs.getString(3) + 
      //               " awayTeam: " + rs.getString(4) + 
      //               " HomeGoals: " + rs.getString(5) + 
      //               " AwayGoals: " + rs.getString(6) + 
      //               " Winner: " + rs.getString(7) + 
      //               " Referee: " + rs.getString(8)
      // ).forEach(str -> System.out.println(str));

      Map<String, Team> teamData = new HashMap<>();

      em.createQuery("select m.homeTeam, count(*) from Match m group by m.homeTeam", Object[].class)
        .getResultList()
        .stream()
        .map(e -> new Team( (String) e[0], (long) e[1] ))
        .forEach(team -> teamData.put(team.getTeamName(), team));

      em.createQuery("select m.awayTeam, count(*) from Match m group by m.awayTeam", Object[].class)
        .getResultList()
        .stream()
        .forEach(e -> {
            Team team = teamData.get((String) e[0]);
            team.setTotalMatches(team.getTotalMatches() + (long) e[1]);
        });

        
      em.createQuery("select m.result, count(*) from Match m where m.result <> 'DRAW' group by m.result ", Object[].class)
        .getResultList()
        .stream()
        .forEach(e -> {
            Team team = teamData.get((String) e[0]);
            team.setTotalWins((long) e[1]);
        });

        em.createQuery("select m.homeTeam, count(*) from Match m where m.result = 'DRAW' group by m.homeTeam", Object[].class)
        .getResultList()
        .stream()
        .forEach(e -> {
          Team team = teamData.get((String) e[0]);
          team.setTotalDraws((long) e[1]);
      });

      em.createQuery("select m.awayTeam, count(*) from Match m where m.result = 'DRAW' group by m.awayTeam", Object[].class)
        .getResultList()
        .stream()
        .forEach(e -> {
            Team team = teamData.get((String) e[0]);
            team.setTotalDraws(team.getTotalDraws() + (long) e[1]);
        });

      teamData.values().forEach(team -> em.persist(team));
      teamData.values().forEach(team -> System.out.println(team));


    }
  }
}
