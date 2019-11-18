package uebung4;
import java.util.*;

/**
* Pennant object to be contained within a Banner
*/
public class Pennant {

    private char color;

    /**
    * @param color character representing the color of the pennant
    */
    public Pennant(char color) {
        this.color = color;
    }

    /**
    * Generates a pennant with a random color
    */
    public Pennant() {
        this.color = (char)((int)(Math.random() * 10));
        System.out.println(this.color);
    }

    /**
    * Color of the Pennant
    * @return color of the pennant
    */
    public char getColor() {
        return this.color;
    }

    /**
    * Colored string representation
    * @return string representation of the pennant
    */
    public String toString() {

        String c = "";

        switch(color) {
            case 'r':
                c = "\033[1;31m";
                break;
            case 's':
                c = "\033[1;30m";
                break;
            case 'g':
                c = "\033[1;33m";
                break;
            case 'b':
                c = "\033[1;34m";
                break;
            case 'w':
                c = "\033[40m\033[1;37m";
                break;
            case 'p':
                c = "\033[1;35m";
                break;
            case 'c':
                c = "\033[1;36m";
                break;
            case 'd':
                c = "\033[1;32m";
                break;
        }

        if (c.equals("")) {
            return c + color + "\033[0m";
        }
            return c + "▼" + "\033[0m";
    }
    
    /**
    * String representation (chars)
    * @return string representation of the pennant as a char
    */
    public String toStringChar() {
        return ""+color;
    }

}
