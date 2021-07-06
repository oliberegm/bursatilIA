package com.olibersystem.bursatil.bursatilia.controller;

import com.olibersystem.bursatil.bursatilia.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ia/api/v1/training")
@Slf4j
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/xor")
    public void xor() {
        trainingService.xorTraining();
    }
}
