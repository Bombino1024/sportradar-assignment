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
        int match1TotalScore = match1.getTotalScore();
        int match2TotalScore = match2.getTotalScore();
        if (match1TotalScore != match2TotalScore) {
            return match2TotalScore - match1TotalScore;
        }
        return match2.getId() - match1.getId();
    }
}
