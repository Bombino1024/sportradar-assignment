package com.sportradar.assignment.scoreboard;

import com.sportradar.assignment.scoreboard.model.Match;
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
    }
}
