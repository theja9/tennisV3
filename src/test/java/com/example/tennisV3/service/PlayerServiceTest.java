package com.example.tennisV3.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @InjectMocks
    PlayerService playerService;

    @Test
    public void incrementPlayerOneScoreBy1() {
        playerService.playerOneScores();
        assertEquals(1, playerService.getPlayerOnePoints());
    }

    @Test
    public void incrementPlayerTwoScoreBy1() {
        playerService.playerTwoScores();
        assertEquals(1, playerService.getPlayerTwoPoints());
    }

}