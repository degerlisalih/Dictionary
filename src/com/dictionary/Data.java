package com.dictionary;


import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/*
 * This is the Data class. It extracts data from englishWords and germanWords files
 */
public class Data {

    private final HashMap<String, String> englishVocabularyMap =new HashMap<>();
    private final HashMap<String, String> germanVocabularyMap =new HashMap<>();

    public Data() {
        setEnglishVocabularyMap();
        setGermanVocabularyMap();
    }

    public HashMap<String, String> getEnglishVocabularyMap() {
        return englishVocabularyMap;
    }

    public void setEnglishVocabularyMap() {

        connectFile("englishWords.txt",englishVocabularyMap);
    }

    public HashMap<String, String> getGermanVocabularyMap() {
        return germanVocabularyMap;
    }

    public void setGermanVocabularyMap() {

         connectFile("germanWords.txt",germanVocabularyMap);
    }

    /*This method finds txt file and extract data from the txt file to Vocabulary hashmap*/
    public void connectFile(String dictionary, HashMap<String, String> VocabularyMap ) {

        try {

            Scanner scanner = new Scanner(new FileReader(dictionary));

            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(" = ");
                VocabularyMap.put(split[0], split[1]);
            }
            /*scanner was reset */
            scanner.close();

        } catch (IOException ioException) {
            System.out.println("exception!! : " + ioException);
        }

    }
}
