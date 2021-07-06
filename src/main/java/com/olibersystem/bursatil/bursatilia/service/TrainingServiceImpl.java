package com.olibersystem.bursatil.bursatilia.service;

import com.olibersystem.bursatil.bursatilia.practicas.Xor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrainingServiceImpl implements TrainingService{
    private final Xor xor;

    public TrainingServiceImpl(Xor xor) {
        this.xor = xor;
    }

    @Override
    public void xorTraining() {
        xor.trainNeuralNetwork();
    }
}
