package uebung2;
import java.util.ArrayList;
import java.lang.Math;

/**
* Manages game, settings and logs
*/
public class Game {

  int numRounds;
  int numPeople;
  int gridSize;
  Grid grid;
  int currentRound;
  ArrayList<LogEntry> log;


  public Game(int gridSize, int numPeople, int numRounds) {
    this.gridSize = gridSize;
    this.numPeople = numPeople;
    this.numRounds = numRounds;
  }

  /**
  * Sets up grid, log and populates the grid with people.
  */
  public void setup() {
    //creates grid and log objects
    this.grid = new Grid(this.gridSize);
    this.log = new ArrayList<LogEntry>();
    this.currentRound = 0;

    Field[][] fields = grid.getFields();

    // Adds people to the fields
    int range = (gridSize-1) + 1;
    for (int i = 0; i < numPeople-2; i++) {
      int a = (int)(Math.random() * range);
      int b =(int)(Math.random() * range);
      fields[a][b].addPerson(new Person(fields[a][b]));
    }

    fields[0][0].addPerson(new Anton(fields[0][0]));
    fields[gridSize-1][gridSize-1].addPerson(new Bertha(fields[gridSize-1][gridSize-1]));
  }

  /**
  * Runs the simulation and logs the results  */
  public void run() {
    int numFields = gridSize*gridSize;
    for (int i = 0; i < numRounds; i++) {

      grid.simulate();

      int negative = 0;
      int neutral = 0;
      int positive = 0;
      int count = 0;
      Field[][] fields = grid.getFields();
      for (Field[] row : fields) {
        for (Field field: row) {
          for (Person person : field.getPeople()) {
            count += 1;
            if (person.getOpinion() == 2) {
              negative += 1;
            } else if (person.getOpinion() == 0) {
              if (person instanceof Bertha) {
                System.out.println("Bertha should not be here. She has a wrong onion.");
              }
              neutral += 1;
            } else {
//              if (person instanceof Bertha) {
//                System.out.println("Bertha should not be here. She has a wrong onion.");
//              }
              positive += 1;
            }
          }
        }
      }
      log.add(
        new LogEntry(
          (double) positive/numPeople,
          (double) negative/numPeople,
          (double) neutral/numPeople
        )
      );
      System.out.println("There still is " + count + " peoplez");
    }
  }

  /**
  * Prints the entire log
  */
  public void printLog() {
    for (int i = 0; i < log.size(); i++) {
      LogEntry entry = log.get(i);
      System.out.printf("Round %d\n", i);
      System.out.printf("\t- Deny: %f\n", entry.getNumNegative());
      System.out.printf("\t/ Neutral: %f\n", entry.getNumNeutral());
      System.out.printf("\t+ Believe: %f\n", entry.getNumPositive());
    }
  }

  /**
  * Prints the game settings
  */
  public void printGameInfo() {
    System.out.printf("The Information of the Game\n");
    System.out.printf("\tThe number of the rounds: %d\n", this.numRounds);
    System.out.printf("\tThe number of the people: %d\n", this.numPeople);
    System.out.printf("\tThe size of the grid: %d\n", this.numRounds);
  }

}
/**
* Manages game, settings and logs
*/
