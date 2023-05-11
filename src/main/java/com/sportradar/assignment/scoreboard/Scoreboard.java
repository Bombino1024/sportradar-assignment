package com.sportradar.assignment.scoreboard;

import com.sportradar.assignment.scoreboard.model.Match;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Scoreboard {

    private final AtomicInteger idGenerator;

    public Scoreboard() {
        idGenerator = new AtomicInteger(1);
    }

    public int startMatch(String homeTeam, String awayTeam) {
        if (StringUtils.isBlank(homeTeam) || StringUtils.isBlank(awayTeam)) {
            throw new IllegalArgumentException("home and away team cannot be null nor blank");
        }
        return idGenerator.getAndIncrement();
    }

    public void updateScore(int matchId, int homeTeamScore, int awayTeamScore) {
        throw new NotImplementedException("updateScore is not implemented");
    }

    public List<Match> getSummary() {
        throw new NotImplementedException("getSummary is not implemented");
    }
}
