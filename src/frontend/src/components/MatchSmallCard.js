import React from "react";
import { Link } from "react-router-dom";

export const MatchSmallCard = ({ teamName, match }) => {
  const otherTeam =
    match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
  const otherTeamRoute = `/teams/${otherTeam}`;
  const winningLocation = match.result === match.homeTeam ? "home" : "away";

  return (
    <div className="MatchSmallCard">
      <h3>
        vs
        <Link to={otherTeamRoute}> {otherTeam} </Link>
      </h3>

      {match.result === "DRAW" ? (
        <p>
          DRAW with {otherTeam} by {match.fullTimeHomeGoals} -{" "}
          {match.fullTimeAwayGoals}
        </p>
      ) : (
        <p>
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
