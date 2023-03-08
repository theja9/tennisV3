package com.example.tennisV3.controller;

import com.example.tennisV3.enums.Scorer;
import com.example.tennisV3.service.PlayerService;
import com.example.tennisV3.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TennisController.class)
class TennisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService players;

    @MockBean
    private ScoreService scoreService;

    @ParameterizedTest
    @EnumSource(Scorer.class)
    public void updateScoreTest(Scorer scorer) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tennis/updateScore")
                .param("scorer", scorer.name())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        if (scorer.equals(Scorer.PLAYER_ONE)) {
            verify(players, Mockito.times(1)).playerOneScores();
        } else if (scorer.equals(Scorer.PLAYER_TWO)) {
            verify(players, Mockito.times(1)).playerTwoScores();
        }
    }

    @Test
    public void testGetScore() throws Exception {
        String expectedScore = "Love All";
        when(scoreService.getScore(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(expectedScore);

        mockMvc.perform(MockMvcRequestBuilders.get("/tennis/getScore"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedScore));
    }

    @Test
    void testQuitGame() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tennis/quit"))
                .andExpect(status().isOk());
        verify(scoreService, Mockito.times(1)).resetPoints();
    }

}
