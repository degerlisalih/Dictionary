package com.dictionary;
/*
 *  This is the view class and it takes an input from user and shows the word and meaning
 */


public class WordView extends WordModel {

    public void inputLanguage() {

        System.out.print("choose a dictionary: Turkish -> (German or English) : ");

    }

    public void inputWord() {

        System.out.print("enter a word : ");

    }

    public void printWordMeaning() {

        System.out.println(getWord() + " -> " + getMeaning());
    }

    public void dictionaryNotFound() {

        System.out.println("<- dictionary not found ->");

    }

    public void systemInformation() {
        System.out.println("System exit key : exit");
        System.out.println("dictionary change key : change");
    }

    public void systemExitMessage() {
        System.out.println("---GOOD BY---");
    }

    public void englishLanguageInfo() {
        System.out.println("TURKISH -> ENGLISH");
    }

    public void germanLanguageInfo() {
        System.out.println("TURKISH -> GERMAN");
    }
}
