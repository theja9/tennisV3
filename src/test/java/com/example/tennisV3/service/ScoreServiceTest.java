package com.example.tennisV3.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {

    @InjectMocks
    ScoreService scoreService;

    @ParameterizedTest
    @CsvSource({
            "0,0,Love Love",
            "1,0,Fifteen Love",
            "0,1,Love Fifteen",
            "2,0,Thirty Love",
            "2,1,Thirty Fifteen",
            "3,0,Forty Love",
            "3,1,Forty Fifteen",
            "2,3,Thirty Forty",
            "3,2,Forty Thirty",
            "0,3,Love Forty",
            "3,0,Forty Love",
    })
    public void testGetScore(int playerOnePoints, int playerTwoPoints, String expectedScore) {
        String translatedScore = scoreService.getScore(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, translatedScore);
    }


}