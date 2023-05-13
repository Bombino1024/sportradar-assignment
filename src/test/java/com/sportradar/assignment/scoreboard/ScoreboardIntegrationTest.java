package com.sportradar.assignment.scoreboard;

import com.sportradar.assignment.scoreboard.model.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ScoreboardIntegrationTest {

    private Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        this.scoreboard = new Scoreboard();
    }

    @Test
    void startMatchUpdateScoreFinishGameVerifyEachStep() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        Assertions.assertEquals(1, scoreboard.getSummary().size());

        boolean scoreUpdated = scoreboard.updateScore(matchId, 1, 0);
        Assertions.assertTrue(scoreUpdated);
        List<Match> matches = scoreboard.getSummary();
        Match match = matches.get(0);
        Assertions.assertEquals(1, match.getHomeTeam().getScore());
        Assertions.assertEquals(0, match.getAwayTeam().getScore());

        boolean matchRemoved = scoreboard.finishGame(matchId);
        Assertions.assertTrue(matchRemoved);
        Assertions.assertTrue(scoreboard.getSummary().isEmpty());
    }

    @Test
    void getSummaryReturnsDifferentInstanceOfMatchesListThenIsInScoreboardTest() {
        scoreboard.startMatch("home-team", "away-team");
        List<Match> matches = scoreboard.getSummary();
        matches.add(new Match(1, "home-team", "away-team"));
        Assertions.assertEquals(1, scoreboard.getSummary().size());
    }

    @Test
    void changesOfMatchOutsideOfScoreboardDoesNotAffectStoredMatchTest() {
        int matchId = scoreboard.startMatch("home-team", "away-team");
        scoreboard.updateScore(matchId, 3, 7);
        List<Match> matches = scoreboard.getSummary();
        Match updatedMatch = matches.get(0);
        updatedMatch.getHomeTeam().setScore(9);
        updatedMatch.getAwayTeam().setScore(13);
        Match storedMatch = scoreboard.getSummary().get(0);
        Assertions.assertEquals(storedMatch.getId(), updatedMatch.getId());
        Assertions.assertNotEquals(storedMatch.getHomeTeam().getScore(), updatedMatch.getHomeTeam().getScore());
        Assertions.assertNotEquals(storedMatch.getAwayTeam().getScore(), updatedMatch.getAwayTeam().getScore());
    }
}
