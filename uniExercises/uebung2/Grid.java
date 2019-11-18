package uebung2;
import java.util.ArrayList;

/**
* The grid Person objects move on. 
*/
public class Grid {

  Field[][] fields;
  int size;

  public Grid(int size) {
    this.size = size;
    fields = new Field[size][size];
    for (int y = 0; y < fields.length; y++) {
      for (int x = 0; x < fields[y].length; x++) {
        fields[y][x] = new Field(this, x, y);
      }
    }
  }

  /**
  * Calls the simulate() method on all of its fields.
  */
  public void simulate() {
    // Triple out = new Triple(0, 0, 0);
    for (Field[] row : fields) {
      for (Field f : row) {
        f.simulate();
      }
    }
    // return out;
  }

  /**
  * @return size (width and height) of the grid
  */
  public int getSize() {
    return size;
  }

  /**
  * @ return 2D-array of fields
  */
  public Field[][] getFields() {
    return fields;
  }

}
