package uebung3;

<<<<<<< HEAD
public class TransposeIO {

    FileReader in;
    FileWriter out;
    String fileNameIN;
    String fileNameOUT;
    Encryption encryptor;
    Decryption decryptor;
    public TransposeIO(String fileNameIN, String fileNameOUT){
        this.fileNameIN = fileNameIN;
        this.fileNameOUT = fileNameOUT;

    }
    private writeText(String inputText, String fileName){

    }
    private String readText(String inputText, String fileName){

    }
    public String encryptText(String fileName){

    }
    public String decryptText(String fileName, int key){

    }
    public String decryptText(String fileName){

    }





=======
import java.util.*;
import java.io.*;

public class TransposeIO {

    private FileReader in;
    private FileWriter out;
    private Encryption encryptor;
    private Decryption decryptor;
    private String fileNameIN;
    private String fileNameOUT;
    private String text;
    private String encryptotext;
    private String decryptotext;
    /**
    * Constructor for the IO class
    * @param fileNameIN does what it says on the tin
    * @param key does what it says on the tin
    */
    public TransposeIO(String fileNameIN, String fileNameOUT) {
        this.fileNameIN = fileNameIN;
        this.fileNameOUT = fileNameOUT;
        try {
            in = new FileReader(fileNameIN);
            out = new FileWriter(fileNameOUT);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("uh - io exception bro...");
        }
    }
    /**
    * Writes text using bufferedWriter
    * @param inputText does what it says on the tin
    * @param fileNameOUT does what it says on the tin
    */
    private void writeText(String inputText, String fileNameOUT) {
        try (
             BufferedWriter bw = new BufferedWriter(this.out);
            )
        {
            bw.write(text);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
    * Reads text using bufferedReader
    * @param fileNameIN does what it says on the tin
    */
    private String readText(String fileNameIN) {

        StringBuilder contentBuilder = new StringBuilder();
        try ( BufferedReader br = new BufferedReader(this.in) )
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        this.text = contentBuilder.toString();
        return contentBuilder.toString();
    }
    /**
    * @return read text
    */

    /**
    * reads, encrypts and writes text using bufferedWriter
    * @param fileNameIN does what it says on the tin
    * @param fileNameOUT does what it says on the tin
    */
    public String encryptText(String fileNameIN, String fileNameOUT) {
        this.text = readText(fileNameIN);
        this.encryptor = new Encryption(fileNameIN);
        this.encryptotext = encryptor.encrypt(text);
        this.writeText(encryptotext, fileNameOUT);
        return encryptotext;
    }
    /**
    * @return encrypted text
    */

    /**
    * reads, encrypts and writes text using bufferedWriter
    * @param fileNameIN does what it says on the tin
    * @param fileNameOUT does what it says on the tin
    * @param key encryption key
    */
    public String encryptText(String fileNameIN, String fileNameOUT, String key) {
        this.readText(fileNameIN);
        this.encryptor = new Encryption(fileNameIN, key);
        this.encryptotext = encryptor.encrypt(text);
        this.writeText(encryptotext, fileNameOUT);
        return encryptotext;
    }
    /**
    * @return encrypted text
    */

    /**
    * reads, decrypts and writes text using bufferedWriter
    * @param fileNameIN does what it says on the tin
    * @param fileNameOUT does what it says on the tin
    * @param key decryption key
    */
    public String decryptText(String fileNameIN, String fileNameOUT, String key) {
        this.readText(fileNameIN);
        this.decryptor = new Decryption(text, key);
        this.decryptotext = decryptor.decrypt();
        this.writeText(decryptotext, fileNameOUT);
        return decryptotext;
    }
    /**
    * @return decrypted text
    */

    /**
    * reads, encrypts and writes text using bufferedWriter
    * @param fileNameIN does what it says on the tin
    * @param fileNameOUT does what it says on the tin
    */
    public String decryptText(String fileNameIN, String fileNameOUT) {
        this.readText(fileNameIN);
        this.decryptor = new Decryption(text);
        this.decryptotext = decryptor.decrypt();
        this.writeText(decryptotext, fileNameOUT);
        return decryptotext;
    }
    /**
    * @return decrypted text
    */
>>>>>>> c158a3eaf230a4af50687c299499c23303154c80
}
