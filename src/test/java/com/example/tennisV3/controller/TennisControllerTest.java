package com.example.tennisV3.controller;

import com.example.tennisV3.enums.Scorer;
import com.example.tennisV3.service.PlayerService;
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

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@WebMvcTest(TennisController.class)
class TennisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService players;

    @ParameterizedTest
    @EnumSource(Scorer.class)
    void updateScoreTest(Scorer scorer) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tennis/updateScore")
                .param("scorer", scorer.name())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        if (scorer.equals(Scorer.PLAYER_ONE)) {
            verify(players, Mockito.times(1)).playerOneScores();
        } else {
            verify(players, never()).playerOneScores();
        }
    }
}
