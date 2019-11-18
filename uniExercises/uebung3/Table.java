package uebung3;

import java.util.TreeMap;
import java.lang.StringBuilder;

/*
* Table for transposing characters
*/
public class Table {

    int key;
    TreeMap<Character, Character> charMap;

    /*
    * @param key encryption key
    */
    public Table(int key) {
        this.key = key;
        this.generateMap();
    }

    /*
    * Sets up the lookup map.
    * @return the generated TreeMap
    */
    private TreeMap<Character, Character> generateMap() {
        this.charMap = new TreeMap<Character, Character>();
        // generates an array of characters representing the alphabet
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i=0; i<26; i++) {
            this.charMap.put(alphabet[i], alphabet[(i+key) % 26]);
        }

        return this.charMap;
    }

    /*
    * Transposes a character.
    * @return encrypted char
    */
    public char encryptChar(char c) {
        try {
            char returni = charMap.get(c);
            System.out.println(returni);
            return returni;
        } catch(NullPointerException e) {
            System.out.println("cant do this dude: " + c);
            return c;
        }
    }

    /*
    * Transposes the character back (reverse lookup).
    * @return decrypted char
    */
    public char decryptChar(char v) {
        for (char c : this.charMap.keySet()) {
            if (this.charMap.get(c).equals(v)) {
                return c;
            }
        }
        // could not be decrypted (and probably wasn't encrypted in the first place)
        return v;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char c : this.charMap.keySet()) {
            sb.append(c + " " + this.charMap.get(c) + "\n");
        }
        return sb.toString();
    }
}
