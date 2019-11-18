package uebung2;

/**
* Executable class that runs the game.
*/
public class Main {

  public static void main(String args[]) {
  
    int gridSize = 10;
    int numPeople = 500;
    int numRounds = 100;

    if (args.length < 0) {
      gridSize = 10;
      numPeople = 500; 
      numRounds = 5;      
    } else {
      gridSize = Integer.parseInt(args[0]);
      numPeople = Integer.parseInt(args[1]);
      numRounds = Integer.parseInt(args[2]);
    }

    Game game = new Game(gridSize, numPeople, numRounds);
    game.setup();
    game.run();

    game.printLog();
    System.out.println("Bertha in denial? - "+LogEntry.ISBERTHADENIAL);
  }
}
