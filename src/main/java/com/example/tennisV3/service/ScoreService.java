package com.example.tennisV3.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScoreService {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private static final Map<Integer, String> SCORE_MAP = new HashMap<>();
    static {
        SCORE_MAP.put(ZERO, LOVE);
        SCORE_MAP.put(ONE, FIFTEEN);
        SCORE_MAP.put(TWO, THIRTY);
    }

    public String getScore(int playerOneScore, int playerTwoScore) {
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private String translateScore(int score) {
        return SCORE_MAP.get(score);
    }

}
