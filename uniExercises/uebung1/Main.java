package uebung1;
/**
  *@author Marv Thiel
  */

public class Main {

  public static void main(String[] args) {

    // Number of tries for each run
    int[] triesArray = new int[] {10, 1000, 100000, 10000000, 1000000000};

    for (int numTries : triesArray) {

      System.out.printf("Tries: %d\n", numTries);

      // Creates the six-sided die and its experiment
      Die dieSix = new Die(6);
      Experiment exp1 = new Experiment(dieSix, numTries);

      // Creates the coin and its experiment
      Die coin = new Die(2);
      Experiment exp2 = new Experiment(coin, numTries);

      // Rolls the dice
      exp1.simulateTries();
      exp2.simulateTries();

      // Prints experiment info
      System.out.println("Experiment 1 (D6)");
      exp1.printInfo();

      System.out.println("Experiment 2 (D2)");
      exp2.printInfo();
    }
  }
}
