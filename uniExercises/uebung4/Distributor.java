package uebung4;

import java.util.*;
import java.lang.*;


/**
* The distributor creates banners and arranges them in a way that their layout is optimally and evenly spread out.
*/
public class Distributor {
    private Map<Character, Integer> charMap;
    private int numEntries = 0;
    private double HEAT_CONSTANT = 100.0;
    /**
    * Clears the CharMap
    */
    public Distributor (double HEAT_CONSTANT) {
        this.charMap = new HashMap<Character, Integer>();
        this.HEAT_CONSTANT = HEAT_CONSTANT;
    }
    
    /**
    * Sets up the distributor by counting the number of pennants of each color.
    * @param chars Array of strings. One string corresponds to a color.
    */
    public void setup(List<String> chars) {
        for (String arg1 : chars) {
            if (arg1.length() > 1) {
                throw new IllegalArgumentException("Only put single-character chars in the arguments.");
            }
            
            char arg = arg1.charAt(0);
            if (charMap.containsKey(arg)) {
                charMap.put(arg, (charMap.get(arg)+1));
                numEntries++;
            } else {
                charMap.put(arg, 1);
                numEntries++;
            }
        }
        System.out.println(charMap.toString());
    }

    /**
    * Recursively wrapper class for the 2 recursive heuristics
    * @param bestBanner Banner object to reorder
    * @param heat Initial or current heat. The heat indicates the occurrence of changes to the banner. When the changes in quality stagnate and the heat reaches 0 the banner will be returned.
    */
    public Banner simulatedAnnealing(Banner bestBanner, double heat) {
        Banner prevBanner = new Banner(bestBanner.getLength(), bestBanner.getPennants());
        System.out.println("Annealing | Currently Distributing: Status - "+bestBanner.toString()+" Quality: "+bestBanner.getQuality());
        
        bestBanner = this.distribute(bestBanner, HEAT_CONSTANT);
        System.out.println("Annealing | Currently Shifting:     Status - "+bestBanner.toString()+" Quality: "+bestBanner.getQuality());
        Banner afterShift = this.shift(bestBanner, HEAT_CONSTANT);
        afterShift.assessQuality();
        
        if (afterShift.getQuality().compareTo(prevBanner.getQuality()) > 0) {
            System.out.println("Annealing | Quality before shift: "+prevBanner.getQuality().toString()+" - Quality after Shift: "+bestBanner.getQuality().toString());
            bestBanner = afterShift;
            heat = HEAT_CONSTANT;
            return simulatedAnnealing(afterShift, heat);
        
        } else if (heat > 0.1){
            heat = heat * 0.99;
            System.out.println("Annealing | Heat: "+heat);
            return simulatedAnnealing(afterShift, heat);
       
        } else {
            return bestBanner;
        }
    }

    /**
    * Recursively finds the best alternative using random heuristic
    * @param banner Banner object to reorder
    * @param heat Initial or current heat. The heat indicates the occurrence of changes to the banner. When the changes in quality stagnate and the heat reaches 0 the banner will be returned.
    */
    private Banner distribute(Banner banner, double heat) {
        // System.out.println("Heat at: " +  heat);
        if (heat <= 0.1) {
            return banner;
        }
        Banner randomBanner = createRandomBanner();

        if (randomBanner.getQuality().compareTo(banner.getQuality()) > 0) {
            return distribute(randomBanner, HEAT_CONSTANT);
        } else {
            heat = heat * 0.99;
            return distribute(banner, heat);
        }
    }

    /**
    * Recursively finds the best alternative using swapping heuristic
    * @param bestBanner Banner to be reordered
    * @param heat Initial or current heat
    */
    private Banner shift(Banner bestBanner, double heat) {
        Banner bShifted = new Banner(bestBanner.getLength(), bestBanner.getPennants());
        List<Pennant> pShift = bShifted.getPennants();

        // attempts to swap all pennants with another to see if a better combination can be found
        for (int i = 0; i < pShift.size(); i++) {
            for (int j = 0; j < pShift.size(); j++) {
                Collections.swap(pShift, i, j);
                bShifted.setPennants(pShift);
                bShifted.assessQuality();
                
                // tests if quality of the shifted banner is better
                if (bShifted.getQuality().compareTo(bestBanner.getQuality()) > 0) {
                    // replaces the currently best banner with the new one
                    bestBanner.setPennants(pShift);
                    bestBanner.assessQuality();
                    System.out.println("Shifting  | Shift found better solution! - "+bestBanner.toString()+" New Quality: "+bestBanner.getQuality());
                    // resets heat
                    heat = HEAT_CONSTANT;
                } else {
                    Collections.swap(pShift, j, i);
                }
            }
        }
        if (heat < 0.1) {
            // returns the banner as heat reached 0
            return bestBanner;
        } else {
            // decreases heat because nothing happened and calls again
            heat = heat * 0.99;
            return shift(bestBanner, heat);
        }
    }


    /**
    * Creates a banner with randomly allocated Pennants
    * @return Banner based on the charMap of the Distributor object
    */
    public Banner createRandomBanner() {
        Banner banner = new Banner(charMap.keySet().size());
        for (char c : charMap.keySet()) {
            for (int i = 0; i < charMap.get(c); i ++) {
                banner.addPennant(new Pennant(c));
            }
        }
        Collections.shuffle(banner.getPennants());
        return banner;
    }
}
