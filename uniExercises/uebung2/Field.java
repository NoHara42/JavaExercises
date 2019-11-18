package uebung2;

import java.util.*;

/**
* Field within the game Grid
*/
public class Field {

    private Grid grid;
    private Field[][] fields;
    private int coordX;
    private int coordY;
    private List<Person> people = new ArrayList<Person>();


    /**
    * @param grid the grid which all fields are contained in
    * @param coordX x coord of field in grid
    * @param coordY y coord of field in grid
    *
    */
    public Field(Grid grid, int coordX, int coordY) {
        this.grid = grid;
        this.fields = grid.getFields();
        this.coordX = coordX;
        this.coordY = coordY;
    }

    /**
    * @param person Person object to add to people ArrayList
    *
    */
    public void addPerson(Person person) {
      this.people.add(person);
    }

    public List<Person> getPeople() {
      return this.people;
    }
    /**
    * @return list of people
    *
    */

    /**
    * Checks number of Person objects in people List for states of opinion
    * and changes the state of all Person objects within the field if prerequisite
    * conditions are met. Also puts Bertha in denialState. Also migrates all people after rounds.
    */
    public void simulate() {
        int neutral = 0; //getOpinion == 0
        int rumourBelievers = 0; // 1
        int denialBelievers = 0; // 2

        //counts number of people on field.
        for (Person person : people) {
            if (person.getOpinion() == 0) {
                neutral++;
            } else if (person.getOpinion() == 1) {
                rumourBelievers++;
            } else if (person.getOpinion() == 2) {
                denialBelievers++;
            } else System.out.println("not valid opinion wtf");
            if(person instanceof Bertha) {
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
                System.out.println("Field x: "+coordX+" - y: "+coordY+" - BERTHA IS HERE");
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
            } else if(person instanceof Anton) {
              System.out.println("----------------------------------------");
              System.out.println("----------------------------------------");
              System.out.println("Field x: "+coordX+" - y: "+coordY+" - ANTON IS HERE");
              System.out.println("----------------------------------------");
              System.out.println("----------------------------------------");
            }
        }

        //field change condition
        if (rumourBelievers>denialBelievers){
          System.out.println("Field x: "+coordX+" - y: "+coordY+" - Population: "+people.size()+" - Rumour win.");
          System.out.println("Neutral: "+neutral+" - RumourBelievers: "+rumourBelievers+" - DenialBelievers: "+denialBelievers);
          for (Person person : people) {
            if((person instanceof Bertha) && (person.getOpinion() == 0)) { // && (rumourBelievers > 0)) {
                person.setOpinion(1);
                LogEntry.berthaDenial();
            } else if (person instanceof Bertha) {
                continue;
            } else if (person instanceof Anton) {
                continue;
            } else {
              person.setOpinion(1);
            }
          }
        //field change condition
        } else if (rumourBelievers<denialBelievers) {
          System.out.println("Field x: "+coordX+" - y: "+coordY+" - Denial win.");
          System.out.println("Neutral: "+neutral+" - RumourBelievers: "+rumourBelievers+" - DenialBelievers: "+denialBelievers);
          for (Person person : people) {
            if((person instanceof Bertha) && (person.getOpinion() == 0)) { // && (rumourBelievers > 0)) {
                person.setOpinion(2);
                LogEntry.berthaDenial();
            } else if (person instanceof Bertha) {
                continue;
            } else if (person instanceof Anton) {
                continue;
            } else {
              person.setOpinion(2);
            }
          }
        //field change condition
        } else if (rumourBelievers==denialBelievers){
          System.out.println("Field x: "+coordX+" - y: "+coordY+" - Neutralisation.");
          System.out.println("Neutral: "+neutral+" - RumourBelievers: "+rumourBelievers+" - DenialBelievers: "+denialBelievers);
          for (Person person : people) {
            if ((person instanceof Bertha) && (person.getOpinion() == 0)) { // && (rumourBelievers > 0)) {
                person.setOpinion(2);
                LogEntry.berthaDenial();
            } else if (person instanceof Bertha) {
                continue;
            } else if (person instanceof Anton) {
                continue;
            } else {
              person.setOpinion(0);
            }
          }
        }
        //people iterator ??? clones the people ArrayList and migrates them
        ArrayList<Person> itrPeople = new ArrayList<Person>(people);
        for (Person person : itrPeople) {
          person.migrate();
        }

    }

    /**
    * Get an adjacent neighbouring Field object.
    *
    */
    public Field getRandomNeighbour() {
        // int coordEndOfAxis = (int)Math.sqrt(grid.getSize())-1;
        int coordEndOfAxis = grid.getSize()-1;
        //if this is on boundary checks
        //METHOD 1: would have to include all corner cases too
        int randomRange = 0;
        List<Field> randomFields = new ArrayList<Field>();
        if (this.coordX == 0 && this.coordY == 0) {
            //oben links
            randomRange = 3;
            randomFields.add(fields[this.coordY][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX+1]);
//            randomFields.add(fields[this.coordY+1][this.coordX]);
        } else if (this.coordX == coordEndOfAxis && this.coordY == 0) {
            //oben rechts
            randomRange = 3;
            randomFields.add(fields[this.coordY][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX-1]);
            randomFields.add(fields[this.coordY+1][this.coordX]);

        } else if (this.coordX == 0 && this.coordY == coordEndOfAxis) {
            //unten links
            randomRange = 3;
            randomFields.add(fields[this.coordY][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX+1]);
            randomFields.add(fields[this.coordY-1][this.coordX]);

        } else if (this.coordX == coordEndOfAxis && this.coordY == coordEndOfAxis) {
            //unten rechts
            randomRange = 3;
            randomFields.add(fields[this.coordY][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX-1]);
            randomFields.add(fields[this.coordY-1][this.coordX]);
        } else if (this.coordY == 0) {
            //top edge
            randomRange = 4;
            randomFields.add(fields[this.coordY][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX+1]);
            randomFields.add(fields[this.coordY][this.coordX-1]);
            randomFields.add(fields[this.coordY+1][this.coordX]);
        } else if (this.coordY == coordEndOfAxis) {
            //bottom edge
            randomRange = 4;
            randomFields.add(fields[this.coordY][this.coordX+1]);
            randomFields.add(fields[this.coordY][this.coordX-1]);
            randomFields.add(fields[this.coordY-1][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX]);
        } else if (this.coordX == 0 ) {
            //left edge
            randomRange = 4;
            randomFields.add(fields[this.coordY][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX+1]);
            randomFields.add(fields[this.coordY-1][this.coordX]);
            randomFields.add(fields[this.coordY+1][this.coordX]);
        } else if (this.coordX == coordEndOfAxis) {
            //right edge
            randomRange = 4;
            randomFields.add(fields[this.coordY][this.coordX]);
            randomFields.add(fields[this.coordY+1][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX-1]);
            randomFields.add(fields[this.coordY-1][this.coordX]);
        } else {
            //in the matrix
            randomRange = 5;
            randomFields.add(fields[this.coordY][this.coordX]);
            randomFields.add(fields[this.coordY][this.coordX+1]);
            randomFields.add(fields[this.coordY][this.coordX-1]);
            randomFields.add(fields[this.coordY+1][this.coordX]);
            randomFields.add(fields[this.coordY-1][this.coordX]);
        }
        //selects random number using randomRange
        int randomSelected = (int)(Math.random()*(randomRange-1));
        //selects and returns random neighbouring Field object
        return randomFields.get(randomSelected);

    }
    /**
    * @return Random neighbouring Field object.
    *
    */
    public Grid getGrid() {
        return this.grid;
    }
    /**
    * @return Grid object containing all Field objects.
    *
    */

    public String toString() {
      return "Field: ("+this.coordX+", "+this.coordY+")";
    }

}
