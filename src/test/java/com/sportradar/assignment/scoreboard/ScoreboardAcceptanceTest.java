package com.sportradar.assignment.scoreboard;

import com.sportradar.assignment.scoreboard.model.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ScoreboardAcceptanceTest {

    @Test
    void providedAcceptanceTest() {
        Scoreboard scoreboard = new Scoreboard();

        int id = scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore(id, 0, 5);

        id = scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore(id, 10, 2);

        id = scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore(id, 2, 2);

        id = scoreboard.startMatch("Uruguay", "Italy");
        scoreboard.updateScore(id, 6, 6);

        id = scoreboard.startMatch("Argentina", "Australia");
        scoreboard.updateScore(id, 3, 1);

        List<Match> summary = scoreboard.getSummary();

        Assertions.assertEquals(5, summary.size());

        Match match = summary.get(0);
        Assertions.assertEquals("Uruguay", match.getHomeTeam().getName());
        Assertions.assertEquals(6, match.getHomeTeam().getScore());
        Assertions.assertEquals("Italy", match.getAwayTeam().getName());
        Assertions.assertEquals(6, match.getAwayTeam().getScore());

        match = summary.get(1);
        Assertions.assertEquals("Spain", match.getHomeTeam().getName());
        Assertions.assertEquals(10, match.getHomeTeam().getScore());
        Assertions.assertEquals("Brazil", match.getAwayTeam().getName());
        Assertions.assertEquals(2, match.getAwayTeam().getScore());

        match = summary.get(2);
        Assertions.assertEquals("Mexico", match.getHomeTeam().getName());
        Assertions.assertEquals(0, match.getHomeTeam().getScore());
        Assertions.assertEquals("Canada", match.getAwayTeam().getName());
        Assertions.assertEquals(5, match.getAwayTeam().getScore());

        match = summary.get(3);
        Assertions.assertEquals("Argentina", match.getHomeTeam().getName());
        Assertions.assertEquals(3, match.getHomeTeam().getScore());
        Assertions.assertEquals("Australia", match.getAwayTeam().getName());
        Assertions.assertEquals(1, match.getAwayTeam().getScore());

        match = summary.get(4);
        Assertions.assertEquals("Germany", match.getHomeTeam().getName());
        Assertions.assertEquals(2, match.getHomeTeam().getScore());
        Assertions.assertEquals("France", match.getAwayTeam().getName());
        Assertions.assertEquals(2, match.getAwayTeam().getScore());
    }
}
