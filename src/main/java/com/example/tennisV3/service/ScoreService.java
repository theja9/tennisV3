package com.example.tennisV3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.tennisV3.enums.ScoreConstants.*;

@Service
public class ScoreService {

    @Autowired
    private PlayerService playerService;

    public String getScore(int playerOneScore, int playerTwoScore) {
        if (hasAdvantage(playerOneScore, playerTwoScore)) {
            return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + ADVANTAGE;
        }
        if (isGameOver(playerOneScore, playerTwoScore)) {
            resetPoints();
            return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + WINS;
        }
        if (isScoreEqual(playerOneScore, playerTwoScore)) {
            return playerOneScore > TWO ? DEUCE : translateScore(playerOneScore) + SPACE + ALL;
        }
        return getTranslatedScore(playerOneScore, playerTwoScore);
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

    private String getTranslatedScore(int playerOneScore, int playerTwoScore) {
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private boolean isScoreEqual(int playerOneScore, int playerTwoScore) {
        return playerOneScore == playerTwoScore;
    }

    private boolean isScoreGreaterThanThree(int playerOneScore, int playerTwoScore) {
        return Math.max(playerOneScore, playerTwoScore) > THREE;
    }

    private boolean hasAdvantage(int playerOneScore, int playerTwoScore) {
        return isScoreGreaterThanThree(playerOneScore, playerTwoScore) && isPointDifferenceOne(playerOneScore, playerTwoScore);
    }

    private boolean isGameOver(int playerOneScore, int playerTwoScore) {
        return isScoreGreaterThanThree(playerOneScore, playerTwoScore) && isPointDifferenceGreaterThanOne(playerOneScore, playerTwoScore);
    }

    public void resetPoints() {
        playerService.setPlayerOnePoints(0);
        playerService.setPlayerTwoPoints(0);
    }
}
