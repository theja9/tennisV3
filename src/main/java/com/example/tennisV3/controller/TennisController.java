package com.example.tennisV3.controller;

import com.example.tennisV3.enums.Scorer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tennis")
public class TennisController {

    @GetMapping("/updateScore")
    public void updateScore(@RequestParam Scorer scorer) {

    }
}