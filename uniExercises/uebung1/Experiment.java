package uebung1;
import java.util.ArrayList;
import java.util.List;
/**
  * Holds the die object and the results of rolling it
  * @author Marv Thiel
  */
public class Experiment {
  private long numTries;
  private Die die;
  private int tries[];

  /**
    * @param die Die object
    * @param numTries number of tries
    */
  public Experiment(Die die, int numTries) {
    this.tries = new int[numTries];
    this.die = die;
    this.numTries = numTries;
  }

  /**
    * Returns the number of tries
    * @return number of tries
    */
  public long getNumTries() {
    return numTries;
  }

  /**
    * Returns the Die object
    * @return Die object of the Experiment
    */
  public Die getDie() {
    return die;
  }

  /**
    * Returns the list of results
    * @return list of tries
    */
  public int[] getTries(){
    return tries;
  }

  /**
    * Rolls the die and saves the results in the list of tries
    */
  public void simulateTries() {
    for (int i = 0; i < numTries; i++) {
      tries[i] = die.getResult();
    }
  }

  /**
    * Prints all data of the experiment
    */
  public void printInfo() {
    System.out.printf("\tNumber of tries: %d\n", numTries);
    for (int i = 1; i <= die.getMax(); i++) {
      System.out.printf("\tEvent: %d\n", i);
      System.out.printf("\t\tFrequency: %d\n", Statistics.getFrequency(this, i));
      System.out.printf("\t\tRelative frequency: %f\n", Statistics.getRelativeFrequency(this, i));
      System.out.printf("\t\tProbability: %f\n", Statistics.getProbability(this, i));
      System.out.printf("\t\tAbsolute bias: %f\n", Statistics.getAbsoluteBias(this, i));
      System.out.printf("\t\tRelative bias: %f\n", Statistics.getRelativeBias(this, i));
    }
  }
}
