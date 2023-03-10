package com.example.tennisV3.controller;

import com.example.tennisV3.enums.Scorer;
import com.example.tennisV3.service.PlayerService;
import com.example.tennisV3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tennis")
public class TennisController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ScoreService scoreService;


    @GetMapping("/updateScore")
    public void updateScore(@RequestParam Scorer scorer) {
        if (scorer.equals(Scorer.PLAYER_ONE)) {
            playerService.playerOneScores();
        } else if (scorer.equals(Scorer.PLAYER_TWO)) {
            playerService.playerTwoScores();
        }
    }

    @GetMapping("/getScore")
    public String getScore() {
        return scoreService.getScore(playerService.getPlayerOnePoints(), playerService.getPlayerTwoPoints());
    }

    @GetMapping("/quit")
    public void quitGame() {
        scoreService.resetPoints();
    }

}