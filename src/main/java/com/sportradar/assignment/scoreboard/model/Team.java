package com.sportradar.assignment.scoreboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Team {

    private String name;
    private int score;

    public Team(String name) {
        this.name = name;
        this.score = 0;
    }
}
