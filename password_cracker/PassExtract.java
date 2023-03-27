import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Good for now
 */
public class PassExtract {


    /**
     * @param filePath file
     * @return hashmap of salt password pairs
     */
    public static HashMap<String, String> hashPasswordExtractor(String filePath) throws FileNotFoundException {
        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));

        HashMap<String, String> saltAndPassword = new HashMap<>(21, 1);         //HashMap<Salt, HashSet<Passwords>>

        try {
            String nextRow;
            while ((nextRow = buffRead.readLine()) != null) {
                String currentSalt = extractSalt(nextRow);
                String currentPassword = extractPassword(nextRow);
                saltAndPassword.put(currentSalt, currentPassword);
            }
        } catch (IOException e) {
            System.exit(3);
        }

        return saltAndPassword;
    }



    /**
     * Extracts the hashed password from an old UNIX user entry
     * <p>
     * Example:
     * extractSalt("joe:PkkdSxS1T99gQ:501:501:Joe Panello:/home/joe:/bin/ksh") returns "Pk"
     * extractSalt("bob:X9eZtriXiFfwk:502:502:Bob Roland:/home/bob:/bin/bash") returns "X9"
     *
     * @param userEntry a user entry in old UNIX style
     * @return the salt
     */
    private static String extractSalt(String userEntry) {
        Scanner scanner = new Scanner(userEntry);
        scanner.useDelimiter(":");
        scanner.next();
        return scanner.next().substring(0, 2);
    }



    /**
     * Extracts the hashed password from an old UNIX user entry
     *
     * @param userEntry entry
     * @return password
     */
    private static String extractPassword(String userEntry) {
        Scanner scanner = new Scanner(userEntry);
        scanner.useDelimiter(":");
        scanner.next();
        return scanner.next();
    }
}