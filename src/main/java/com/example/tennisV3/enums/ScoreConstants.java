package com.example.tennisV3.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ScoreConstants {
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    private static final String FORTY = "Forty";
    public static final String ALL = "All";
    public static final String SPACE = " ";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE = "Advantage";
    public static final String PLAYER_ONE = "PlayerOne";
    public static final String PLAYER_TWO = "PlayerTwo";
    public static final String WINS = "Wins";

    public static final Map<Integer, String> SCORE_MAP ;
    static {
        Map<Integer, String> scoreMap = new HashMap<>();
        scoreMap.put(ZERO, LOVE);
        scoreMap.put(ONE, FIFTEEN);
        scoreMap.put(TWO, THIRTY);
        scoreMap.put(THREE, FORTY);
        SCORE_MAP = Collections.unmodifiableMap(scoreMap);
    }

}
