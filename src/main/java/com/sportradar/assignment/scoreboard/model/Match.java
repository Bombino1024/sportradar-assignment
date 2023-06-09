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

    public Match(Match match) {
        this.id = match.id;
        this.homeTeam = new Team(match.homeTeam);
        this.awayTeam = new Team(match.awayTeam);
    }

    public int getTotalScore() {
        return homeTeam.getScore() + awayTeam.getScore();
    }
}
