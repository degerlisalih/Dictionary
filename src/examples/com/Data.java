package examples.com;
/*
 * This is the Data class. It extracts data from englishWords and germanWords files
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Data {

    public HashMap<String, String> englishWordConnection() {
        /*This method finds txt file and extract data from the txt file to englishVocabulary hashmap*/
        HashMap<String, String> englishVocabulary = new HashMap<String, String>();
        String line;
        try {

            BufferedReader reader = new BufferedReader(new FileReader("englishWords.txt"));

            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" = ");
                englishVocabulary.put(split[0], split[1]);
            }
            /*reader was reset */
            reader.close();
            reader = new BufferedReader(new FileReader("englishWords.txt"));

        } catch (IOException ioException) {
            System.out.println("exception!! : " + ioException);
        }

        return englishVocabulary;
    }

    public HashMap<String, String> germanWordConnection() {
        /*This method finds txt file and extract data from the txt file to germanVocabulary hashmap*/
        HashMap<String, String> germanVocabulary = new HashMap<String, String>();
        String line;
        try {

            BufferedReader reader = new BufferedReader(new FileReader("germanWords.txt"));

            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" = ");
                germanVocabulary.put(split[0], split[1]);
            }
            /*reader was reset */
            reader.close();
            reader = new BufferedReader(new FileReader("englishWords.txt"));

        } catch (IOException ioException) {
            System.out.println("exception!! : " + ioException);
        }

        return germanVocabulary;
    }
}
