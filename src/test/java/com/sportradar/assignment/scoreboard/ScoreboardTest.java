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

    @Test
    void startMatchReturnsPositiveInteger() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        Assertions.assertTrue(matchId > 0);
    }

    @Test
    void startMultipleMatchesAndExpectIdsToBeDifferent() {
        int firstMatchId = scoreboard.startMatch("home-team", "away-team");
        int secondMatchId = scoreboard.startMatch("home-team", "away-team");
        Assertions.assertNotEquals(firstMatchId, secondMatchId);
    }

    @Test
    void updateScoreOnEmptyScoreboard() {
        Assertions.assertFalse(scoreboard.updateScore(1, 0, 0));
    }

    @Test
    void updateScoreIsSuccessful() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        Assertions.assertTrue(scoreboard.updateScore(matchId, 0, 0));
    }

    @Test
    void updateScoreHomeTeamNegativeScoreTest() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore(matchId, -1, 0));
    }

    @Test
    void updateScoreAwayTeamNegativeScoreTest() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore(matchId, 5, -5));
    }


}