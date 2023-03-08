package com.example.tennisV3.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private static final String LOVE = "Love";

    public String getScore(int playerOneScore, int playerTwoScore) {
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private String translateScore(int score) {
        if (score == 0) {
            return LOVE;
        }
        return "Invalid Score";
    }

}
