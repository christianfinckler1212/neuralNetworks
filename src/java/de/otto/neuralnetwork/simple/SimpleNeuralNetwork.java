package de.otto.neuralnetwork.simple;

public class SimpleNeuralNetwork {

  Neuron neuron;

  public SimpleNeuralNetwork(final int countOfInputNeurons) {
    this.neuron = new Neuron(countOfInputNeurons);
  }

  public double processInput(double[] input) {
    return neuron.processInput(input);
  }

  public void learnInput(final double[] input, final double expectedOutput) {
   neuron.learnInput(input, expectedOutput);
  }

  public void printWeights() {
    neuron.printWeights();
  }
}
