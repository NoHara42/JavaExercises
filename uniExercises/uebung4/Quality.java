package uebung4;
import java.util.*;


/**
* Quality to measure the distribution of a banner. The first and most important component is distance of pennants with the same color.
* Second priority is the occurrence of that distance.
*/
public class Quality implements Comparable<Quality> {

    private int distance;
    private int occurrence;

    /**
    * Creates a quality object with specified distance and occurrence components.
    * @param distance Distance from one color to another
    * @param occurrence Number of times the distance occurs
    */
    public Quality(int distance, int occurrence) {
        this.distance = distance;
        this.occurrence = occurrence;
    }

    /**
    * Distance component
    * @return distance component of the quality
    */
    public int getDistance() {
        return this.distance;
    }

    /**
    * Occurrence of the quality's distance
    * @return occurrence component of the quality
    */
    public int getOccurrence() {
        return this.occurrence;
    }

    /**
    * Distance of similar pennants
    * @param distance distance of the quality
    */
    public void setDistance(int distance) {
      this.distance = distance;
    }

    /**
    * Sets the occurrence component of the quality
    * @param occurrence occurrence of the quality
    */
    public void setOccurrence(int occurrence) {
      this.occurrence = occurrence;
    }

    /**
    * String representation
    * @return string representation of the quality
    */
    public String toString() {
        return "distance: "+this.distance+" - occurrence: "+this.occurrence;
    }

    /**
    * Compares two Quality objects. Higher distance is the high priority, lower occurrence is the lower priority.
    * @param other Other quality to compare to
    * @return int according to compareTo specification
    */
    @Override
    public int compareTo(Quality other) {
        if (this.distance > other.getDistance()) {
            return 1;
        } else if (this.distance < other.getDistance()) {
            return -1;
        } else if (this.distance == other.getDistance()) {
            if (this.occurrence < other.getOccurrence()) {
                return 1;
            } else if (this.occurrence > other.getOccurrence()) {
                return -1;
            } else {
                return 0;
            }
        }
        return 0;
    }
}
