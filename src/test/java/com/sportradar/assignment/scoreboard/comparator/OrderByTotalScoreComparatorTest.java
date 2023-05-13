package com.sportradar.assignment.scoreboard.comparator;

import com.sportradar.assignment.scoreboard.model.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderByTotalScoreComparatorTest {

    private OrderByTotalScoreComparator comparator;

    @BeforeEach
    void setUp() {
        this.comparator = new OrderByTotalScoreComparator();
    }

    @Test
    void compareNullValuesTest() {
        Assertions.assertEquals(0, comparator.compare(null, null));
    }

    @Test
    void compareFirstMatchNullTest() {
        Assertions.assertEquals(1, comparator.compare(null, new Match(1, "home-team", "away-team")));
    }

    @Test
    void compareSecondMatchNullTest() {
        Assertions.assertEquals(-1, comparator.compare(new Match(1, "home-team", "away-team"), null));
    }

    @Test
    void compareFirstTeamTotalScoreGreaterTest() {
        Match match1 = new Match(1, "home-team-1", "away-team-1");
        Match match2 = new Match(2, "home-team-2", "away-team-2");
        match1.getHomeTeam().setScore(1);
        Assertions.assertEquals(-1, comparator.compare(match1, match2));
    }

    @Test
    void compareTeamScoresAreEqualsTest() {
        Match match1 = new Match(1, "home-team-1", "away-team-1");
        Match match2 = new Match(2, "home-team-2", "away-team-2");
        Assertions.assertEquals(0, comparator.compare(match1, match2));
    }

    @Test
    void compareFirstTeamTotalScoreLowerTest() {
        Match match1 = new Match(1, "home-team-1", "away-team-1");
        Match match2 = new Match(2, "home-team-2", "away-team-2");
        match2.getHomeTeam().setScore(1);
        Assertions.assertEquals(1, comparator.compare(match1, match2));
    }
}