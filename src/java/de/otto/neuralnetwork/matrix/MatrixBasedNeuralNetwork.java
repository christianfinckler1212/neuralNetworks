package de.otto.neuralnetwork.matrix;

import Jama.Matrix;

public class MatrixBasedNeuralNetwork {

  private int nrOfInputNodes;
  private int nrOfOutputNodes;
  Matrix weights;

  public MatrixBasedNeuralNetwork(int nrOfInputNodes, int nrOfOutputNodes, Matrix weights) {
    this.nrOfInputNodes = nrOfInputNodes;
    this.nrOfOutputNodes = nrOfOutputNodes;
    this.weights = weights;
  }

  public Matrix processInput(Matrix input) {
    return weights.times(input);
  }

  public static double sigmoid(double x) {
    return 1 / (1 + Math.pow(Math.E, -1 * x));
  }

  public void learnInput(final Matrix input, final Matrix expectedOutput) {
    final Matrix output = processInput(input);
    //output.print(3, 2);
    final Matrix deltaError = expectedOutput.minus(output);
    //deltaError.print(3, 2);
    final Matrix inputDeltas = deltaError.times(input.transpose());
    //inputDeltas.print(3, 2);
    final Matrix inputDeltasWithLearnFactor = inputDeltas.times(0.000001);
    //inputDeltasWithLearnFactor.print(3, 4);
    final Matrix newWeights = weights.plus(inputDeltasWithLearnFactor);
    //newWeights.print(3, 2);
    weights = newWeights;
  }

  void printWeights() {
    weights.print(3, 5);
  }
}
