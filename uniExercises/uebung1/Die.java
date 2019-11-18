package uebung1;

/**
  *@author Ned O'Hara
  */

public class Die {

  private int max;

  public int getMax() {
    return this.max;
  }
  /**   Returns the maximum possible outcome. In other words, number of possible outcomes.
    *@return Returns the maximum possible outcome. In other words, number of possible outcomes.
    */
  public int getResult() {
    int result = 1 + (int)(Math.random() * max);
    return result;
  }
    /** Returns a random number from 1 to the max (inclusive).
    * @return Random die roll result.
    */

  /** Constructor for Die Object with number of outcomes as parameter.
    *@param max Mumber of possible outcomes.
    */
  public Die(int max) {
    this.max = max;
  }


}
