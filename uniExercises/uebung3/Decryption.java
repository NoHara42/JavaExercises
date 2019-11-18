package uebung3;

import java.lang.StringBuilder;
import java.lang.Math;
import java.util.Scanner;

/**
* Finds keys and decrypts texts
*/
public class Decryption {

    private Integer key;
    private String inputText;
    private Table table;

    /**
    * Constructor for when the key is known
    * @param inputText An encrypted text
    * @param key The encryption key
    */
    public Decryption(String inputText, String key) {
        this.key = Integer.valueOf(key);
        this.inputText = inputText;
        this.table = new Table(this.key);
    }

    /**
    * Constructor for when the key is unknown
    * @param inputText An encrypted text
    */
    public Decryption(String inputText) {
        this.inputText = inputText;
        this.key = this.findKey();
    }

    /**
    * Guesses the key and decrypts the text
    * @return decrypted text
    */
    public String decrypt() {
        StringBuilder sb = new StringBuilder();
        for (char c : this.inputText.toCharArray()) {
            sb.append(table.decryptChar(c));
        }
        return sb.toString();
    }

    /**
    * Statistically guesse the key
    * @return the encryption key
    */
    private int findKey() {
        Scanner input = new Scanner(System.in);


        char[] lettersGer = "enisratdhulcgmobwfkzpvjyxq".toCharArray();

        boolean keyFound = false;
        int currentChar = lettersGer[0];
        int max = 0;
        String s = "";

        while(!keyFound) {
            // counts the occurence of characters
            int[] quantity = new int[26];
            for (char c : this.inputText.toCharArray()) {
                quantity[(int)c-97] += 1;
            }

            // gets the most used character
            max = 0;
            for (int i=0; i<quantity.length; i++) {
                if (quantity[i] > max) {
                    max = i;
                }
            }
            System.out.println(decrypt());
            System.out.println("Does this look like anything do you?");
            s = input.next();
            if (s.equals("y")) {
                keyFound = true;
            } else {
                currentChar += 1;
            }
        }

        // the key is the difference between the actual most used character
        return Math.abs(max - ((int)currentChar-96));
    }
}
