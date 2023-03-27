import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Cracker {



    public static void crackController (String[] dictionary, HashMap<String, String> saltAndPassword) {

        Mangler mr = new Mangler(dictionary);

        while(!saltAndPassword.isEmpty()) {
            try {
                String[] mangledDictionary = mr.nextMangle();
                crackPasswords(mangledDictionary, mangledDictionary.length, saltAndPassword);
            } catch (Exception io) {
                System.out.print(io);
                System.exit(6);
            }
        }
    }

    /**
     * This method attempts to find passwords for a given dictionary
     * @param dictionary
     * @param dictionarySize
     * @param saltAndPassword
     * @return
     * @throws IOException
     */
    private static void crackPasswords
    (String[] dictionary, int dictionarySize, HashMap<String, String> saltAndPassword) {

        HashSet<String> foundPasswords = new HashSet<>();

        for (Map.Entry<String, String> mapElements : saltAndPassword.entrySet()) {

            String encrypted;
            boolean passFound = false;

            for (int i = 0; (i < dictionarySize) && (!passFound); i++) {
                encrypted = jcrypt.crypt(mapElements.getKey(), dictionary[i]);

                if (encrypted.equals(mapElements.getValue())) {
                    passFound = true;
                    System.out.println(dictionary[i]);
                    foundPasswords.add(mapElements.getKey());
                }
            }
        }

        Iterator<String> i = foundPasswords.iterator();
        while (i.hasNext()) {
            saltAndPassword.remove(i.next());
        }
    }

}
