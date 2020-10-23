package examples.com;
/*
 * This is the Data class. It extracts data from englishWords and germanWords files
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Data {

    public HashMap<String, String> englishWordConnection() {
        /*This method finds txt file and extract data from the txt file to englishVocabulary hashmap*/
        HashMap<String, String> englishVocabulary = new HashMap<String, String>();
        try {

            Scanner scanner = new Scanner(new FileReader("englishWords.txt"));

            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(" = ");
                englishVocabulary.put(split[0], split[1]);
            }
            /*scanner was reset */
            scanner.close();

        } catch (IOException ioException) {
            System.out.println("exception!! : " + ioException);
        }

        return englishVocabulary;
    }

    public HashMap<String, String> germanWordConnection() {
        /*This method finds txt file and extract data from the txt file to germanVocabulary hashmap*/
        HashMap<String, String> germanVocabulary = new HashMap<String, String>();
        try {

            Scanner scanner = new Scanner(new FileReader("germanWords.txt"));

            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(" = ");
                germanVocabulary.put(split[0], split[1]);
            }
            /*scanner was reset */
           scanner.close();

        } catch (IOException ioException) {
            System.out.println("exception!! : " + ioException);
        }

        return germanVocabulary;
    }
}
