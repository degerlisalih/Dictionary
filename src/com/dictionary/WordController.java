package com.dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * This is the Controller class. It makes coordination between WordModel and WordView classes
 */

public class WordController {

    Scanner scanner = new Scanner(System.in);

    private HashMap<String, String> wordControllerMap;
    private final WordModel wordModel;
    private final Data data;
    private final WordView wordView;

    public WordController(WordModel wordModel, Data data, WordView wordView) {
        this.wordModel = wordModel;
        this.data = data;
        this.wordView = wordView;
    }

    /*
     *it selects language vocabulary
     */

    public void selectLanguage() {
        wordView.inputLanguage();
        String choice = scanner.nextLine();
        if ("english".equalsIgnoreCase(choice)) {
            wordControllerMap = data.getEnglishVocabularyMap();
            wordView.englishLanguageInfo();
        } else if ("german".equalsIgnoreCase(choice)) {
            wordControllerMap = data.getGermanVocabularyMap();
            wordView.germanLanguageInfo();
        } else if ("exit".equalsIgnoreCase(choice)) {
            wordView.systemExitMessage();
            System.exit(0);
        } else {
            wordView.dictionaryNotFound();
            selectLanguage();
        }
    }

    /*
     *finds the input word in the map
     */
    public void finder() {

        boolean controller = false;
        wordView.inputWord();
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("change")) {
            selectLanguage();
        } else {

            for (Map.Entry<String, String> entry : wordControllerMap.entrySet()) {
                // it tries to find input in the map
                if (entry.getKey().equalsIgnoreCase(input)) {
                    wordModel.setWord(entry.getKey());
                    wordModel.setMeaning(entry.getValue());
                    controller = true;
                    break;
                } else if (input.equalsIgnoreCase("exit")) {
                    wordView.systemExitMessage();
                    System.exit(0);
                }
            }

            if (!controller) {
                wordModel.setWord("<- object not found");
                wordModel.setMeaning("");
            }
            /*
             *  updates word and meaning to the WordView
             */
            wordView.printWordMeaning();
        }
    }


}
