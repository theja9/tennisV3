package com.example.tennisV3.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";

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
        return "Invalid Score";
    }

}
