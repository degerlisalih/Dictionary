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

        String choice = wordView.inputLanguage();
        if ("english".equalsIgnoreCase(choice)) {
            map = data.englishWordConnection();
            wordView.englishLanguage();
        } else if ("german".equalsIgnoreCase(choice)) {
            map = data.germanWordConnection();
            wordView.germanLanguage();
        } else if ("exit".equalsIgnoreCase(choice)) {
            wordView.systemExitMessage();
            System.exit(0);
        } else {
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

            for (Map.Entry<String, String> entry : map.entrySet()) {
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
            wordView.print(wordModel.getWord(), wordModel.getMeaning());
        }
    }


}
