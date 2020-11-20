  /*
   * %W% %E% salih DEGERLI
   *
   * The purpose of this simple program is
   * to easily find the English or german equivalent of Turkish words.
   * It has five classes. Main, Data, WordModel, WordController, WordView.
   *
   */
  package com.dictionary;

  /**
   * This is a Main class and it makes runnable all the other classes.
   *
   * @author Salih DEGERLI
   * @version 1.1.1  23 Oct 2020
   */
  public class Main {

      public static void main(String[] args) {

          WordView wordView = new WordView();
          WordModel wordModel = new WordModel();
          Data data = new Data();
          WordController wordController = new WordController(wordModel, data, wordView);

          wordView.systemInformation();
          wordController.selectLanguage();
          //noinspection InfiniteLoopStatement
          while (true) {
              wordController.finder();
          }
      }
  }