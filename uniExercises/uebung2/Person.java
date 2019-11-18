package uebung2;

import java.util.*;

/**
* Represents a person on the game grid.
*/
public class Person {

    private Field field;
    private int opinion;

    /**
    * @param origin
    *
    */
    public Person(Field origin) {
        this.field = origin;
        this.opinion = 0;
    }

    /**
    *  Uses getRandomNeighbour() to find a neighbouring field to transfer to.
    *  Also moves people from prior field.
    */
    public Field migrate() {
        //temp variable targetField??
        Field targetField = this.field;
        this.field = targetField.getRandomNeighbour();
        //checks that the chosen random field is not the same as the original field and moves people if this is the case
        if (!targetField.equals(this.field)) {
          targetField.getPeople().remove(this);
          this.field.getPeople().add(this);
        }
        System.out.printf("Migrating from %s to %s\n", targetField, this.field);
        return this.field;
    }
    /**
    * @return field after migration.
    */

    public int getOpinion() {
        return this.opinion;
    }
    /**
    * @return int for opinion state.
    *
    */

    /**
    * @param opinion
    *
    */
    public void setOpinion(int opinion) {

        this.opinion = opinion;
    }

    public Field getField() {
        return this.field;
    }
    /**
    * @return Field object containing Person List.
    *
    */


}
