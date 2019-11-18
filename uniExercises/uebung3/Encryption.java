package uebung3;

<<<<<<< HEAD
public class Encryption {

    private String inputText;
    private int key;

    public Encryption(String inputText, int key) {

        this.inputText = inputText;
        this.key = key;
    }
    public encrypt(String inputText, int key) {

    }
    public encrypt(String inputText) {

    }
    private String encryptText(String inputText, int key) {

=======
import java.util.*;

/**
* Encrypts texts
*/
public class Encryption {

    private Integer key;
    private String inputText;
    private Table table;

    /**
    * Constructor for when the key is known
    * @param inputText An encrypted text
    * @param key The encryption key
    */
    public Encryption(String inputText, String key) {
        try {
            this.key = Integer.valueOf(key);
            this.inputText = inputText;
            this.table = new Table(this.key);
        } catch (Exception e) {
            System.err.println("you cant encrypt this character you asshat - numbers ONLY");
        }
    }

    /**
    * Constructor for when the key is randomly set between 0 and Integer.MAX_VALUE
    * @param inputText An encrypted text
    */
    public Encryption(String inputText) {
        this.key = (int)(Math.random()*Integer.MAX_VALUE);
        this.inputText = inputText;
        this.table = new Table(this.key);
    }



    /**
    * Encrypts the text
    * @return encrypted text
    */
    public String encrypt() {
        System.out.println(table.toString());
        StringBuilder sb = new StringBuilder();
        for (char c : this.inputText.toCharArray()) {
            sb.append(table.encryptChar(c));
        }
        return sb.toString();
>>>>>>> c158a3eaf230a4af50687c299499c23303154c80
    }

}
