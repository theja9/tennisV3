package com.example.tennisV3.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";

    public String getScore(int playerOneScore, int playerTwoScore) {
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private String translateScore(int score) {
        if (score == 0) {
            return LOVE;
        }
        if(score == 1) {
            return FIFTEEN;
        }
        if(score == 2) {
            return THIRTY;
        }
        return "Invalid Score";
    }

}
