package com.olibersystem.bursatil.bursatilia.practicas;

import lombok.extern.slf4j.Slf4j;
import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.Neuron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.ConnectionFactory;
import org.neuroph.util.NeuralNetworkType;
import org.neuroph.util.TransferFunctionType;
import org.neuroph.util.random.WeightsRandomizer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Random;

@Component
@Slf4j
public class Xor {
    private MultiLayerPerceptron neuralNetwork;

    @PostConstruct
    public void init() {
        neuralNetwork = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 2, 4, 1);
        neuralNetwork.randomizeWeights(new WeightsRandomizer(new Random(123)));
    }

    public void trainNeuralNetwork() {
        int inputSize = 2;
        int outputSize = 1;

        // create training set (logical XOR function)
        DataSet trainingSet = new DataSet(inputSize, outputSize);
        trainingSet.add(new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainingSet.add(new DataSetRow(new double[]{0, 1}, new double[]{1}));
        trainingSet.add(new DataSetRow(new double[]{1, 0}, new double[]{1}));
        trainingSet.add(new DataSetRow(new double[]{1, 1}, new double[]{0}));

        BackPropagation backPropagation = new BackPropagation();
        //backPropagation.setMaxIterations(1000);
        backPropagation.setLearningRate(0.05);
        backPropagation.addListener( event -> {
            BackPropagation bp = (BackPropagation)event.getSource();
            if (event.getEventType() != LearningEvent.Type.LEARNING_STOPPED)
                log.info(bp.getCurrentIteration() + ". iteration : "+ bp.getTotalNetworkError());
        });
        neuralNetwork.setLearningRule(backPropagation);
        log.info("init learn");
        neuralNetwork.learn(trainingSet);
        log.info("{}", Arrays.toString(neuralNetwork.getWeights()));
    }

    public Double evaluate(Double eval1, Double eval2 ) {
        log.info("Calculating performance indicators for neural network.");
        neuralNetwork.setInput(eval1,eval2);
        neuralNetwork.calculate();
        double[] output = neuralNetwork.getOutput();
        log.info("Output {}", Arrays.toString(output));
        return output[0];
    }

}
