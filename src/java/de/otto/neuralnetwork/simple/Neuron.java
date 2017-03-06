package de.otto.neuralnetwork.simple;

import static java.lang.Math.random;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Neuron {

  private final double[] weigths;

  Neuron(final int countOfWeigths) {
    this.weigths = new double[countOfWeigths];
    for (int i = 0; i < weigths.length; i++) {
      weigths[i] = random();
    }
  }

  double processInput(final double[] input) {
    double sum = 0;
    for (int i = 0; i < input.length; i++) {
      sum += input[i] * weigths[i];
    }
    return sum;
  }

  void learnInput(final double[] input, final double expectedResult) {

    //newWeight = weight + deltaError * input * learningFactor
    final double output = processInput(input);
    //output.print(3, 2);
    final double deltaError = expectedResult - output;
    //deltaError.print(3, 2);
    for (int i = 0;i < input.length; i++) {
      weigths[i] = weigths[i] + deltaError * input[i] * 0.000001;
    }

  }

  void printWeights() {
    System.out.println(Arrays.stream(weigths).mapToObj(value -> String.format( "%.5f", value )).collect(Collectors.joining(" ")));
  }
}
