package com.sportradar.assignment.scoreboard;

import com.sportradar.assignment.scoreboard.model.Match;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Scoreboard {
    public int startMatch(String homeTeam, String awayTeam) {
        if (StringUtils.isBlank(homeTeam) || StringUtils.isBlank(awayTeam)) {
            throw new IllegalArgumentException("home and away team cannot be null nor blank");
        }
        return 1;
    }

    public void updateScore(int matchId, int homeTeamScore, int awayTeamScore) {
        throw new NotImplementedException("updateScore is not implemented");
    }

    public List<Match> getSummary() {
        throw new NotImplementedException("getSummary is not implemented");
    }
}
