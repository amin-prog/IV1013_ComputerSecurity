import java.lang.System;
import java.lang.Long;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.Random;

public class StreamCipher {

    public static void main (String[] args) {

        if (args.length < 3) {
            System.out.println("Too few arguments");
            System.exit(1);
        }

        long encryptionKey;
        String inputFile = args[1];
        String outputFile = args[2];

        try {
            encryptionKey = Long.parseLong(args[0]);
            InputStream inputStream;
            OutputStream outputStream;

            try {
                inputStream = new BufferedInputStream(new FileInputStream(inputFile));
                outputStream = new BufferedOutputStream(new FileOutputStream(outputFile, false));

                MyRandom rand = new MyRandom(encryptionKey);
                int nextRand;
                int nextByte;
                int encryptedByte;

                try {
                    while ((nextByte = inputStream.read()) != -1) {
                        nextRand = rand.next(8);
                        encryptedByte = (nextByte ^ nextRand);
                        outputStream.write(encryptedByte);
                    }
                } catch (Exception e) {
                    System.out.println("Problems when en-/decrypting");
                }

                try {
                    inputStream.close();
                    outputStream.close();
                } catch (java.io.IOException a) {
                    System.out.println("Input or output stream could not be closed");
                    System.exit(3);
                }

            } catch (FileNotFoundException b) {
                System.out.println(b);
                System.out.println("File could not be found");
                System.exit(4);
            }

        }
        catch (NumberFormatException c) {
            System.out.println("Wrong number seed format, should be integer");
            System.exit(5);
        }
    }
}