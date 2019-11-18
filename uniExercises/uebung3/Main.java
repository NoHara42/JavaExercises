package uebung3;

<<<<<<< HEAD
public class Main {


    public static void main(String[] args) {


=======
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //java encrypt/decrypt fileIn fileOut Key
        TransposeIO io = new TransposeIO(args[1],args[2]);

            if(args[0].equals("encrypt") && (args.length == 4)) {
                io.encryptText(args[1], args[2], args[3]);
            } else if (args[0].equals("decrypt") && (args.length == 4)) {
                io.decryptText(args[1], args[2], args[3]);
            } else if (args[0].equals("encrypt") && (args.length == 3)) {
                io.encryptText(args[1], args[2]);
            } else if (args[0].equals("decrypt") && (args.length == 3)) {
                io.decryptText(args[1], args[2]);
            } else System.out.println("more args pls watwatwatwatwat");
>>>>>>> c158a3eaf230a4af50687c299499c23303154c80


    }

<<<<<<< HEAD
    
=======
>>>>>>> c158a3eaf230a4af50687c299499c23303154c80
}
