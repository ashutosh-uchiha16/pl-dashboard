import React from "react";
import { Link } from "react-router-dom";
import "./MatchSmallCard.scss";

export const MatchSmallCard = ({ teamName, match }) => {
  const otherTeam =
    match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
  const otherTeamRoute = `/teams/${otherTeam}`;
  const winningLocation = match.result === match.homeTeam ? "home" : "away";

  const result =
    match.result === teamName
      ? "MatchSmallCard won-card"
      : match.result === "DRAW"
      ? "MatchSmallCard draw-card"
      : "MatchSmallCard loss-card";
  return (
    <div className={result}>
      <span>vs</span>

      <h1>
        <Link to={otherTeamRoute}> {otherTeam} </Link>
      </h1>

      {match.result === "DRAW" ? (
        <p className="match-result">
          DRAW with {otherTeam} by {match.fullTimeHomeGoals} -{" "}
          {match.fullTimeAwayGoals}
        </p>
      ) : (
        <p className="match-result">
          {match.result} won by{" "}
          {winningLocation === "home"
            ? match.fullTimeHomeGoals
            : match.fullTimeAwayGoals}{" "}
          -{" "}
          {winningLocation === "away"
            ? match.fullTimeHomeGoals
            : match.fullTimeAwayGoals}
        </p>
      )}
    </div>
  );
};
