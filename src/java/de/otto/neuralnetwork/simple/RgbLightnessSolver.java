package de.otto.neuralnetwork.simple;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RgbLightnessSolver {

  private static final Map<double[], Double> trainingData = getTrainingData();

  private static Map<double[], Double> getTrainingData() {
    final Map<double[], Double> map = new HashMap<>();
    for (int i = 0; i < 10000; i++) {
      final double v1 = Math.random() * 100;
      final double v2 = Math.random() * 100;
      final double v3 = Math.random() * 100;
      map.put(new double[]{v1, v2, v3}, (v1 + v2 + v3) / 3);
    }
    return Collections.unmodifiableMap(map);
  }

  public static void main(final String[] args) {
    final SimpleNeuralNetwork simpleNeuralNetwork =
      new SimpleNeuralNetwork( 3);

    trainingData.entrySet().forEach(entry -> {
      simpleNeuralNetwork.printWeights();
      simpleNeuralNetwork.learnInput(entry.getKey(), entry.getValue());
    });
  }

}
