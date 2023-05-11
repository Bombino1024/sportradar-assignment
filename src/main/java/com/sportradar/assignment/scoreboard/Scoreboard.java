package com.sportradar.assignment.scoreboard;

import com.sportradar.assignment.scoreboard.model.Match;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Scoreboard {

    private final AtomicInteger idGenerator;
    private final HashMap<Integer, Match> matches;

    public Scoreboard() {
        idGenerator = new AtomicInteger(1);
        matches = new HashMap<>();
    }

    public int startMatch(String homeTeam, String awayTeam) {
        if (StringUtils.isBlank(homeTeam) || StringUtils.isBlank(awayTeam)) {
            throw new IllegalArgumentException("home and away team cannot be null nor blank");
        }
        int matchId = idGenerator.getAndIncrement();
        matches.put(matchId, new Match(matchId, homeTeam, awayTeam));
        return matchId;
    }

    public boolean updateScore(int matchId, int homeTeamScore, int awayTeamScore) {
        Match match = matches.get(matchId);
        if (match == null) {
            log.warn("Unable to update score for match with id {}, match not found", matchId);
            return false;
        }
        return true;
    }

    public List<Match> getSummary() {
        throw new NotImplementedException("getSummary is not implemented");
    }
}
