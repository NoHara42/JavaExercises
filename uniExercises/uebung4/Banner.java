package uebung4;
import java.util.*;

/**
* The Banner holds a list of pennants, has a length and a quality by which its distribution can be measured.
*/
public class Banner {

    private List<Pennant> pennants;
    private int length;
    private Quality quality;

    /**
    * Creates a banner with a certain length and a given list of pennants
    * @param length number of pennants
    * @param pennants List of Pennant objects
    */
    public Banner(int length, List<Pennant> pennants) {
        this.length = length;
        this.pennants = pennants;
    }
    
    /**
    * Creates a banner with a certain length
    * @param length number of pennants
    */
    public Banner(int length) {
        this.length = length;
        this.pennants = new ArrayList<Pennant>();
    }

    /**
    * Quality of the banner's layout. The quality will be assessed if it hasn't been already. Otherwise make sure to run assessQuality when changes to the banner have been made.
    * @return quality of the banner
    */
    public Quality getQuality() {
        if (this.quality == null) {
            this.assessQuality();
        }
        return this.quality;
    }

    /**
    * Assesses the quality of a Banner and sets the object's attribute.
    */
    public void assessQuality() {
        Quality bestQuality = new Quality(9999,0);
        List<Pennant> pennantList = this.getPennants();
        // System.out.println("Pennant order: "+pennantList.toString());
        int startingIndex = 1;
        
        for (Pennant pennant : pennantList) {
            char colorSelect = pennant.getColor();
            int distanceBetweenLikeColors = 0;
            
            for (int i = startingIndex; i < pennantList.size(); i++) {
                
                if (
                    (pennantList.get(i).getColor() == (pennant.getColor()))
                    && (bestQuality.getDistance() >= distanceBetweenLikeColors)
                ) {
                    if (distanceBetweenLikeColors < bestQuality.getDistance()) {
                      bestQuality.setDistance(distanceBetweenLikeColors);
                      bestQuality.setOccurrence(1);
                    } else if (distanceBetweenLikeColors == bestQuality.getDistance()){
                      bestQuality.setDistance(distanceBetweenLikeColors);
                      bestQuality.setOccurrence(bestQuality.getOccurrence()+1);
                    }
                    // System.out.println("Pennant: "+pennant.toString()+" - distance: "+distanceBetweenLikeColors);
                    distanceBetweenLikeColors = 0;
                    break;
                
                } else if ((pennantList.get(i).getColor() != (pennant.getColor()))) {
                    distanceBetweenLikeColors++;
                    continue;
                
                } else {
                    distanceBetweenLikeColors++;
                    continue;
                }
            }
            startingIndex++;
        }
        this.quality = bestQuality;
    }


    static int factorial(int n) {    
        if (n == 0)    
            return 1;    
        else    
            return(n * factorial(n-1));    
    }    

    /**
    * Calculates the number of equivalent solutions using factorials: a! + b! + c! + ...
    * Where for example a is the number of colors that occur 3 times, b the number of colors that occur 2 times, c the number of colors that occur once.
    * @return number of equivalent solutions (incl. self)
    */
    public int getEquivalents() {
        // map: occurrence of a character : how many characters occur that often
        HashMap<Integer, Integer> occurrenceCounts = new HashMap<Integer, Integer>();

        ArrayList<Character> colors = new ArrayList<Character>();

        // Finds out which colors are in the banner
        for (Pennant p : this.pennants) {
            if (!colors.contains(p.getColor())) {
                colors.add(p.getColor());
            }
        }

        // counts how often each color occurs
        for (char color : colors) {
            int count = 0;
            for (Pennant p : this.pennants) {
                if (p.getColor() == color) {
                    count += 1;
                }
            }
            // takes note of how often the color occurs (which color is irrelevant, so it just notes the count)
            occurrenceCounts.putIfAbsent(count, 0);
            occurrenceCounts.put(count, occurrenceCounts.get(count) + 1);
        }

        int numEquivalents = 0;

        // calculates the number of permutations using factorials
        for (int occCount : occurrenceCounts.keySet()) {
            if (numEquivalents == 0) {
                numEquivalents = factorial(occurrenceCounts.get(occCount));
                continue;
            }
            numEquivalents *= factorial(occurrenceCounts.get(occCount));
        }

        return numEquivalents;
    }

    /**
    * Number of pennants in the banner
    * @return number of pennants in the banner 
    */
    public int getLength() {
        return this.length;
    }

    /**
    * List of Pennant objects
    * @return list of Pennant objects
    */
    public List<Pennant> getPennants() {
        return this.pennants;
    }

    /**
    * Replaces the list of pennants
    * @param pennants List of pennants to replace the banner's own list
    */
    public void setPennants(List<Pennant> pennants) {
        this.pennants = pennants;
    }

    /**
    * Adds a pennant to the banner
    * @param pennant Pennant object to be added to the banner
    */
    public void addPennant(Pennant pennant) {
        pennants.add(pennant);
    }

    /**
    * String representation of the Banner
    * @return string prepresentation of the banner
    */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pennant p : pennants) {
            sb.append(p.toString());
        }
        return sb.toString();
    }

    /**
    * String representation of the Banner (chars)
    * @return string prepresentation of the banner
    */
    public String toStringChars() {
        StringBuilder sb = new StringBuilder();
        for (Pennant p : pennants) {
            sb.append(p.toStringChar());
        }
        return sb.toString();
    }
}
