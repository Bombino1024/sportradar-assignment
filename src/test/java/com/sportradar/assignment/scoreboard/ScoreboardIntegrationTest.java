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
        List<Match> mathces = scoreboard.getSummary();
        Match match = mathces.get(0);
        Assertions.assertEquals(1, match.getHomeTeam().getScore());
        Assertions.assertEquals(0, match.getAwayTeam().getScore());

        boolean matchRemoved = scoreboard.finishGame(matchId);
        Assertions.assertTrue(matchRemoved);
        Assertions.assertTrue(scoreboard.getSummary().isEmpty());
    }
}
