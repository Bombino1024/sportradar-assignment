package com.sportradar.assignment.scoreboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Match {

    private int id;
    private Team homeTeam;
    private Team awayTeam;
}
