package com.sportradar.assignment.scoreboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {

    private Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    void startMatchWithHomeTeamNullOrBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch(null, "away-team"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("", "away-team"));
    }

    @Test
    void startMatchWithAwayTeamNullOrBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("home-team", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("home-team", ""));
    }
}