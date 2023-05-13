package com.sportradar.assignment.scoreboard.comparator;

import com.sportradar.assignment.scoreboard.model.Match;

import java.util.Comparator;

public class OrderByTotalScoreAndIdDescendingComparator implements Comparator<Match> {

    @Override
    public int compare(Match match1, Match match2) {
        if (match1 == null && match2 == null) {
            return 0;
        } else if (match1 == null) {
            return 1;
        } else if (match2 == null) {
            return -1;
        }
        if (match1.getTotalScore() != match2.getTotalScore()) {
            return match2.getTotalScore() - match1.getTotalScore();
        }
        return match2.getId() - match1.getId();
    }
}
