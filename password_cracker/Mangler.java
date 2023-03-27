/**
 * This class is used for String mangling
 */
public class Mangler {
    private String[] dictionary;
    private String[] mangledDictionary;

    private final int dictionarySize;
    private int number;

    private int mangleCalls;

    private final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                                    'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                    'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public Mangler(String[] dictionary) {
        this.dictionary = dictionary;
        mangledDictionary = new String[dictionary.length];
        number = 0;
        dictionarySize = dictionary.length;
        mangleCalls = 0;
    }

    public String[] nextMangle() throws IllegalArgumentException{
        switch (mangleCalls) {
            case 0:
                toUpperCase();
                break;
            case 1:
                toLowerCase();
                break;
            case 2:
                duplicate();
                break;
            case 3:
                deleteFirst();
                break;
            case 4:
                deleteLast();
                break;
            case 5:
                capitalize();
                break;
            case 6:
                nCapitalize();
                break;
            case 7:
                reverse();
                break;
            case 8:
                reflect2();
                break;
            case 9:
                reflect();
                break;
            default:
                throw new IllegalArgumentException();
        }
        mangleCalls++;
        return mangledDictionary;
    }

    private void toUpperCase() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i].toUpperCase();
    }

    private void toLowerCase() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i].toLowerCase();
    }

    private void duplicate() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i].concat(dictionary[i]);
    }

    private void deleteFirst() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i].substring(1);
    }

    private void deleteLast() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i].substring(0, dictionary[i].length());
    }

    private void capitalize() {
        toLowerCase();
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i].substring(0,1).toUpperCase() + dictionary[i].substring(1);
    }

    private void nCapitalize() {
        toUpperCase();
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i].substring(0, 1).toLowerCase() + dictionary[i].substring(1);
    }

    private void reverse() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = new StringBuilder(dictionary[i]).reverse().toString();
    }

    private void reflect() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i] + new StringBuilder(dictionary[i]).reverse().toString();
    }

    private void reflect2() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = new StringBuilder(dictionary[i]).reverse().toString()  + dictionary[i];
    }

    /*
    private void prependNumber() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = number + dictionary[i];
    }
     */

    /*
    private void appendNumber() {
        for (int i = 0; i < dictionarySize; i++)
            mangledDictionary[i] = dictionary[i] + number;
    }
     */

    /*
    private void toggleCase() {

    }
     */
}