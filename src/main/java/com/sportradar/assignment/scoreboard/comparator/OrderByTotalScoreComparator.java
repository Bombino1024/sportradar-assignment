package com.sportradar.assignment.scoreboard.comparator;

import com.sportradar.assignment.scoreboard.model.Match;

import java.util.Comparator;

public class OrderByTotalScoreComparator implements Comparator<Match> {

    @Override
    public int compare(Match match1, Match match2) {
        if (match1 == null && match2 == null) {
            return 0;
        } else if (match1 == null) {
            return 1;
        } else if (match2 == null) {
            return -1;
        }
        return match2.getTotalScore() - match1.getTotalScore();
    }
}
