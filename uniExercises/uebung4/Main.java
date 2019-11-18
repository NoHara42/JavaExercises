package uebung4;
import java.util.*;

/**
* Creates a banner with specified colors and lays it out in an optimal way based on the quality of the banner.
*/
public class Main {

    /**
    * Ultimately defines for how long an optimal solution is searched for. Heat indicates the occurrence of better alternative banners when an optimal banner layout is looked for.
    */
    public static double HEAT_CONSTANT = 50.0;

    /**
    * Creates a new distributor object and sets it up with the specified colors, then finds an optimally distributed banner layout.<br>
    * @param args List of single-character color strings (for example r r r b g g w w)
    */
    public static void main(String[] args) {

        Distributor distributor = new Distributor(HEAT_CONSTANT);
        ArrayList<String> colors = new ArrayList<String>();

        // Checks if the input consists of pairs
        if (args.length % 2 != 0) {
            System.out.println("Error: Uneven number of arguments");
            return;
        }

        // Adds all colors to a list
        for (int i = 0; i < args.length; i += 2) {
            for (int j = 0; j < Integer.parseInt(args[i + 1]); j += 1) {
                colors.add(args[i]);
            }
        }

        // Sets up the distributor and generates an optimal banner
        distributor.setup(colors);
        Banner bestBanner = distributor.createRandomBanner();
        bestBanner = distributor.simulatedAnnealing(bestBanner, HEAT_CONSTANT);
        
        System.out.println(bestBanner.toString());
        System.out.println(bestBanner.toStringChars());
        System.out.println(bestBanner.getQuality());
        System.out.println("Number of equivalent solutions: " + bestBanner.getEquivalents());

    }

}
