package examples.com;
/*
 * This is the Controller class. It makes coordination between WordModel and WordView classes
 * Besides it selects language vocabulary , finds the input word in the map and
 * updates word and meaning to the WordView
 */

import java.util.HashMap;
import java.util.Map;

public class WordController {

    private final WordModel wordModel;
    private final Data data;
    private final WordView wordView;


    public WordController(WordModel wordModel, Data data, WordView wordView) {
        this.wordModel = wordModel;
        this.data = data;
        this.wordView = wordView;
    }


    public HashMap<String, String> map = null;

    public void selectLanguage() {

        try {
            String s = wordView.inputLanguage();
            switch (s) {
                case "english" -> {
                    map = data.englishWordConnection();
                    System.out.println("TURKISH -> ENGLISH");
                }
                case "german" -> {
                    map = data.germanWordConnection();
                    System.out.println("TURKISH -> GERMAN");
                }
                case "exit" -> {
                    System.out.println("---GOOD BY---");
                    System.exit(0);
                }
            }
        } catch (NullPointerException nullPointerException) {
            wordView.printNotFound();
            selectLanguage();
        }
    }


    public void finder() {

        boolean controller = false;
        String input = wordView.inputWord();
        if (input.equalsIgnoreCase("change")) {
            selectLanguage();
        } else {

            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    // it tries to find input in the map
                    if (entry.getKey().equalsIgnoreCase(input)) {
                        wordModel.setWord(entry.getKey());
                        wordModel.setMeaning(entry.getValue());
                        controller = true;
                        break;
                    } else if (input.equalsIgnoreCase("exit")) {
                        System.out.println("---GOOD BY---");
                        System.exit(0);
                    }
                }

            } catch (NullPointerException nullPointerException) {
                wordView.printNotFound();
                selectLanguage();
            }
            if (!controller) {
                wordModel.setWord("<- object not found");
                wordModel.setMeaning("");
            }
            wordView.print(wordModel.getWord(), wordModel.getMeaning());
        }
    }


}
