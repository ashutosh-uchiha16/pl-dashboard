import React from "react";
import { Link } from "react-router-dom";
import "./MatchDetailCard.scss";

export const MatchDetailCard = ({ match, teamName }) => {
  if (!match) return null;

  const otherTeam =
    match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
  const otherTeamRoute = `/teams/${otherTeam}`;

  const result =
    match.result === teamName
      ? "MatchDetailCard won-card"
      : match.result === "DRAW"
      ? "MatchDetailCard draw-card"
      : "MatchDetailCard loss-card";

  const winningLocation = match.result === match.homeTeam ? "home" : "away";
  return (
    <div className={result}>
      <div>
        <span className="vs">vs</span>
        <h1>
          <Link to={otherTeamRoute}> {otherTeam} </Link>
        </h1>
        {match.result === "DRAW" ? (
          <h3 className="match-result">
            DRAW with {otherTeam} by {match.fullTimeHomeGoals} -{" "}
            {match.fullTimeAwayGoals}
          </h3>
        ) : (
          <h3 className="match-result">
            {match.result} won by{" "}
            {winningLocation === "home"
              ? match.fullTimeHomeGoals
              : match.fullTimeAwayGoals}{" "}
            -{" "}
            {winningLocation === "away"
              ? match.fullTimeHomeGoals
              : match.fullTimeAwayGoals}
          </h3>
        )}
        <h2 className="match-date">{match.date}</h2>
      </div>
      <div className="additional-details">
        <h3 className="match-venue"> Stadium:</h3>
        <p>{match.stadium} </p>

        <h3>Referee:</h3>
        <p>{match.referee}</p>
      </div>
    </div>
  );
};
