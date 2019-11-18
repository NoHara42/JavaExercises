package uebung2;


  /**
  * Holds information of each game round
  */
public class LogEntry {

  double numPositive;
  double numNeutral;
  double numNegative;
  static boolean ISBERTHADENIAL = false;

  public LogEntry(double numPositive, double numNegative, double numNeutral) {
    this.numPositive = numPositive;
    this.numNeutral = numNeutral;
    this.numNegative = numNegative;
  }

  /**
  * @return number of Person objects with a positive opinion
  */
  public double getNumPositive() {
    return this.numPositive;
  }

  /**
  * @return number of Person objects with a neutral opinion
  */
  public double getNumNeutral() {
    return this.numNeutral;
  }

  /**
  * @return number of Person objects with a negative opinion
  */
  public double getNumNegative() {
    return this.numNegative;
  }

  /**
  * Debug: whether the Bertha object has a negative opinion.
  */
  public static void berthaDenial() {
    ISBERTHADENIAL = true;
  }

}
