import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {

    /**
     * Extract passwords from file to array
     * @param filepath path to dictionary file from working diectory where this is executed
     * @return an array with all of the dictionary entries from file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[] dictionaryExtractor (String filepath) throws FileNotFoundException, IOException{
        ArrayList<String> dictionary = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String nextLine;
        while ((nextLine = reader.readLine()) != null) {
            dictionary.add(nextLine);
        }
        return dictionary.toArray(new String[dictionary.size()]); //OR dictionary.size()?? Depends on JVM optimizations
    }

}
