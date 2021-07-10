import React from "react";
import { Link } from "react-router-dom";

export const MatchDetailCard = ({ match, teamName }) => {
  if (!match) return null;

  const otherTeam =
    match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
  const otherTeamRoute = `/teams/${otherTeam}`;

  //   const winner = match.result;
  const winningLocation = match.result === match.homeTeam ? "home" : "away";
  //   const drawCard = () => {
  //     if (winner === "draw") {
  //       return (
  //         <h3>
  //           {teamName} drew with {otherTeam} by {match.fullTimeHomeGoals} -{" "}
  //           {match.fullTimeAwayGoals}
  //         </h3>
  //       );
  //     }
  //   };

  //   const winCard = () => {
  //     return (
  //       <h3>
  //         {match.result} won by{" "}
  //         {location === "home"
  //           ? match.fullTimeHomeGoals
  //           : match.fullTimeAwayGoals}{" "}
  //         -{" "}
  //         {location === "away"
  //           ? match.fullTimeHomeGoals
  //           : match.fullTimeAwayGoals}
  //       </h3>
  //     );
  //   };
  return (
    <div className="MatchDetailCard">
      <h3>Latest Matches</h3>

      <h1>
        vs
        <Link to={otherTeamRoute}> {otherTeam} </Link>
      </h1>
      <h2>{match.date}</h2>
      <h3> at {match.stadium} </h3>
      {/* {console.log(winner)} */}
      {match.result === "DRAW" ? (
        <h3>
          DRAW with {otherTeam} by {match.fullTimeHomeGoals} -{" "}
          {match.fullTimeAwayGoals}
        </h3>
      ) : (
        <h3>
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
    </div>
  );
};
