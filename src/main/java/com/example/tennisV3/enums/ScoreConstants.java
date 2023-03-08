package com.example.tennisV3.enums;

import java.util.HashMap;
import java.util.Map;

public class ScoreConstants {
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    public static final Map<Integer, String> SCORE_MAP = new HashMap<>();
    static {
        SCORE_MAP.put(ZERO, LOVE);
        SCORE_MAP.put(ONE, FIFTEEN);
        SCORE_MAP.put(TWO, THIRTY);
    }
}
