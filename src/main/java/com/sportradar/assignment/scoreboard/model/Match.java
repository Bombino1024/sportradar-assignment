package com.sportradar.assignment.scoreboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Match {

    private int id;
    private Team homeTeam;
    private Team awayTeam;

    public Match(int matchId, String homeTeam, String awayTeam) {
        this.id = matchId;
        this.homeTeam = new Team(homeTeam);
        this.awayTeam = new Team(awayTeam);
    }
}
