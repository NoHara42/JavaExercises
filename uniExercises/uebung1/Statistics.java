package uebung1;

import java.util.*;

/**
*@author Ned O'Hara
*/
public class Statistics {
  /**
    * @param exp the experiment instance
    * @param event the dice outcome to find the occurances of
    */
  public static Long getFrequency(Experiment exp, int event) {
    int[] tries = exp.getTries();
    Long eventCounter = 0L;

    for (Integer entry : tries) {
      if (entry == event) {
          eventCounter++;
      }
    }
    return eventCounter;
  }
  /**
    * @return eventCounter is the number of times the number event was found in the ArrayList
    */

  /**
    * @param exp the experiment instance
    * @param event the dice outcome to find the occurances of
    *
    */
  public static double getRelativeFrequency(Experiment exp, int event) {

    int[] tries = exp.getTries();
    Long eventCounter = 0L;
    for (Integer entry : tries) {
      if (entry == event) {
          eventCounter++;
      }
    }
    return (((double)eventCounter)/((double)exp.getNumTries()));
  }
  /**
    * @return returns the relative frequency
    */

  /**
    * @param exp the experiment instance
    * @param event the dice outcome to find the occurances of
    *
    */
  public static double getProbability(Experiment exp, int event) {
    int numberOfSides = exp.getDie().getMax();
    double probability = 1.0/numberOfSides;
    return probability;
  }
  /**
    * @return returns the absolute probability
    */

  /**
    * @param exp the experiment instance
    * @param event the dice outcome to find the occurances of
    *
    */
  public static double getAbsoluteBias(Experiment exp, int event) {
    double absBias = Statistics.getRelativeFrequency(exp, event) - Statistics.getProbability(exp, event);
    return absBias;
  }
  /**
    * @return returns the absolute bias
    */
  /**
    * @param exp the experiment instance
    * @param event the dice outcome to find the occurances of
    *
    */
  public static double getRelativeBias(Experiment exp, int event) {
    double relBias = Math.abs(Statistics.getAbsoluteBias(exp, event)/Statistics.getProbability(exp, event));
    return relBias;
  }
  /**
    * @return returns the relative bias
    */
}
