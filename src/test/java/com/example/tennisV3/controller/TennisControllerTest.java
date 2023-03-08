package com.example.tennisV3.controller;

import com.example.tennisV3.enums.Scorer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TennisController.class)
class TennisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @EnumSource(Scorer.class)
    void updateScoreTest(Scorer scorer) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tennis/updateScore")
                .param("scorer", scorer.name())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
