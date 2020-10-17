package examples.com;
/*
 *  This is the view class and it takes an input from user and shows the word and meaning
 */

import java.util.Scanner;

public class WordView {

    public static Scanner scanner = new Scanner(System.in);

    public String inputLanguage() {

        System.out.print("choose a dictionary(german or english) : ");

        return scanner.nextLine();
    }

    public String inputWord() {

        System.out.print("enter a word : ");

        return scanner.nextLine();
    }

    public void print(String word, String meaning) {

        System.out.println(word + " -> " + meaning);
    }

    public void printNotFound() {

        System.out.println("<- dictionary not found ->");

    }

}