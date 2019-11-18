package uebung2;
import java.util.*;

/**
* Person that spreads a positive opinion.
*/
public class Anton extends Person {

    private Field field;
    private int opinion;

    /**
    * @param origin
    *
    */
    public Anton(Field origin) {
        super(origin);
        this.field = super.getField();
        this.opinion = 1;
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
        System.out.printf("Migrating ANTON from %s to %s\n", targetField, this.field);
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
        //does not change after being set.
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
