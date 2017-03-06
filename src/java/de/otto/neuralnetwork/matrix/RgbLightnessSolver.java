package de.otto.neuralnetwork.matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import Jama.Matrix;

public class RgbLightnessSolver {

  private static final Map<Matrix, Matrix> trainingData = getTrainingData();

  private static Map<Matrix, Matrix> getTrainingData() {
    final Map<Matrix, Matrix> map = new HashMap<>();
    for (int i = 0; i < 10000; i++) {
      final double v1 = Math.random() * 100;
      final double v2 = Math.random() * 100;
      final double v3 = Math.random() * 100;
      map.put(createVector(v1, v2, v3), createVector((v1 + v2 + v3) / 3));
    }
    return Collections.unmodifiableMap(map);
  }

  public static void main(final String[] args) {
    final MatrixBasedNeuralNetwork matrixBasedNeuralNetwork =
      new MatrixBasedNeuralNetwork(3, 1, createVector(Math.random(), Math.random(), Math.random()));

    trainingData.entrySet().forEach(entry -> {
      matrixBasedNeuralNetwork.printWeights();
      matrixBasedNeuralNetwork.learnInput(entry.getKey().transpose(), entry.getValue());
    });
  }

  private static Matrix createVector(final double... values) {
    return new Matrix(values, 1);
  }

  private static double squareSum(final Matrix matrix) {
    return Arrays.stream(matrix.getColumnPackedCopy())
      .map(value -> value * value)
      .reduce(0, Double::sum);
  }
}
