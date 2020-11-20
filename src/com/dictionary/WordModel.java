
package com.dictionary;

/*
 * this is the model class and it determines types of variables
 */

public class WordModel {

    private static String word;
    private static String meaning;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {

        WordModel.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        WordModel.meaning = meaning;
    }
}