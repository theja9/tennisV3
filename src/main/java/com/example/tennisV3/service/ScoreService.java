package com.example.tennisV3.service;

import org.springframework.stereotype.Service;

import static com.example.tennisV3.enums.ScoreConstants.*;

@Service
public class ScoreService {

    public String getScore(int playerOneScore, int playerTwoScore) {
        if (Math.max(playerOneScore, playerTwoScore) > THREE && isPointDifferenceOne(playerOneScore, playerTwoScore)) {
            return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + ADVANTAGE;
        }
        if (Math.max(playerOneScore, playerTwoScore) > THREE && isPointDifferenceGreaterThanOne(playerOneScore, playerTwoScore)) {
            return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + WINS;
        }
        if (playerOneScore > TWO && playerOneScore == playerTwoScore) {
            return DEUCE;
        }
        if (playerOneScore == playerTwoScore) {
            return translateScore(playerOneScore) + SPACE + ALL;
        }
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private String translateScore(int score) {
        return SCORE_MAP.get(score);
    }

    private boolean isPointDifferenceOne(int playerOneScore, int playerTwoScore) {
        return Math.abs(playerOneScore - playerTwoScore) == ONE;
    }

    private String getHighestScorer(int playerOneScore, int playerTwoScore) {
        return playerOneScore > playerTwoScore ? PLAYER_ONE : PLAYER_TWO;
    }

    private boolean isPointDifferenceGreaterThanOne(int playerOneScore, int playerTwoScore) {
        return Math.abs(playerOneScore - playerTwoScore) >= TWO;
    }

}
