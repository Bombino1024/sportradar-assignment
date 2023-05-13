package com.sportradar.assignment.scoreboard;

import com.sportradar.assignment.scoreboard.model.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void updateScoreExpectScoreToBeUpdated() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        scoreboard.updateScore(matchId, 2, 3);
        List<Match> matches = scoreboard.getSummary();
        Match match = matches.get(0);
        Assertions.assertEquals(2, match.getHomeTeam().getScore());
        Assertions.assertEquals(3, match.getAwayTeam().getScore());
    }

    @Test
    void finishGameOnEmptyScoreBoard() {
        Assertions.assertFalse(scoreboard.finishGame(1));
    }

    @Test
    void finishGameInvalidMatchIdTest() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        Assertions.assertFalse(scoreboard.finishGame(matchId + 1));
    }

    @Test
    void finishGameSuccessTest() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        Assertions.assertTrue(scoreboard.finishGame(matchId));
    }

    @Test
    void getSummaryOrderedByTotalScoreTest() {
        int matchId = scoreboard.startMatch("home-team-1", "away-team-1");
        scoreboard.updateScore(matchId, 1, 0);
        scoreboard.startMatch("home-team-2", "away-team-2");
        Assertions.assertEquals(matchId, scoreboard.getSummary().get(0).getId());
    }

    @Test
    void getSummaryOrderedByTotalScoreExpectOrderIsChangedTest() {
        scoreboard.startMatch("home-team-1", "away-team-1");
        int matchId = scoreboard.startMatch("home-team-2", "away-team-2");
        scoreboard.updateScore(matchId, 1, 0);
        Assertions.assertEquals(matchId, scoreboard.getSummary().get(0).getId());
    }
}