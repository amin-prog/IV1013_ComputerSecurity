/**
 * Doc
 * @// FIXME: 2021-05-07 Implement multithreading
 */

import java.io.*;
import java.util.*;
import java.lang.System;

public class PasswordCrack {

    public static void main(String[] args) {

        if (args.length != 2)
            System.exit(1);

        String dictionaryFile = args[0];
        String hashedPasswordFile = args[1];

        HashMap <String, String> saltAndPassword;
        String[] dictionaryEntries;

        try {
            saltAndPassword = PassExtract.hashPasswordExtractor(hashedPasswordFile);

            try {
                dictionaryEntries = Dictionary.dictionaryExtractor(dictionaryFile);

                Cracker.crackController(dictionaryEntries, saltAndPassword);

            } catch (Exception k) {
                System.err.print(k);
                System.exit(5);
            }

        } catch (FileNotFoundException b) {
            System.out.println(b);
            System.exit(2);
        }

        //Read in dictionary and passwordFiles
        //jcrypt for dictionaryEntries
        //Compare to passwordfiles
        //
        //Print and repeat
    }



    /**
     * Print hashMap
     * @param entrySet
     */
    private static void printHashMap(Set<Map.Entry<String, String>> entrySet) {
        for (Map.Entry<String, String> mapElements : entrySet) {
            System.out.println("\n" + mapElements.getKey());
            System.out.println(mapElements.getValue());
        }
    }
}