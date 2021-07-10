import React from "react";

export const MatchSmallCard = ({ match }) => {
  return (
    <div className="MatchSmallCard">
      <p>
        {match.homeTeam} vs {match.awayTeam}
      </p>
    </div>
  );
};
