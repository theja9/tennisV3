package com.example.tennisV3.service;

import org.springframework.stereotype.Service;

import static com.example.tennisV3.enums.ScoreConstants.*;

@Service
public class ScoreService {

    public String getScore(int playerOneScore, int playerTwoScore) {
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private String translateScore(int score) {
        return SCORE_MAP.get(score);
    }

}
