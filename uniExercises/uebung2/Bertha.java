package uebung2;
import java.util.*;

/**
* Person that denies any positive opinion and sticks to a negative opinion.
*/
public class Bertha extends Person {

    private Field field;
    private int opinion;
    private boolean opinion_fixed;
    /**
    * @param origin
    *
    */
    public Bertha(Field origin) {
        super(origin);
        this.field = super.getField();
        this.opinion = 0;
        this.opinion_fixed = false;
    }


    /**
    *  Uses getRandomNeighbour() to find a neighbouring field to transfer to.
    *  Also moves people from prior field.
    */
    @Override
    public Field migrate() {
        //temp variable targetField??
        Field targetField = this.field;
        this.field = targetField.getRandomNeighbour();
        //checks that the chosen random field is not the same as the original field and moves people if this is the case
        if (!targetField.equals(this.field)) {
          targetField.getPeople().remove(this);
          this.field.getPeople().add(this);
        }
        System.out.printf("Migrating BERTHA from %s to %s\n", targetField, this.field);
        return this.field;
    }
    /**
    * @return field after migration.
    */

    /**
    * @param opinion
    *
    */
    @Override
    public void setOpinion(int opinion) {
        if (!this.opinion_fixed && (opinion == 1 || opinion == 2)) {
            this.opinion = 2;
            this.opinion_fixed = true;
            System.out.println("########################################");
            System.out.println("########################################");
            System.out.println("BERTHA IN DENIAL");
            System.out.println("########################################");
            System.out.println("########################################");
        }
    }

    public int getOpinion() {
        return this.opinion;
    }
    public Field getField() {
        return this.field;
    }
    /**
    * @return Field object containing Person List.
    *
    */

}
