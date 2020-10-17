  /*
   * %W% %E% salih DEGERLI
   *
   * The purpose of this simple program is to easily find the English or german equivalent of Turkish words.
   * It has five classes. Main, Data, WordModel, WordController, WordView.
   *
   */
  package examples.com;

  /**
   * This is a Main class and it makes runnable all the other classes.
   *
   * @author Salih DEGERLI
   * @version 1.1.0  16 Oct 2020
   */

  public class Main {

      public static void main(String[] args) {
          Data data = new Data();
          WordModel wordModel = new WordModel();
          WordView wordView = new WordView();
          WordController wordController = new WordController(wordModel,data,wordView);

          System.out.println("System exit key : exit");
          System.out.println("dictionary change key : change");

          wordController.selectLanguage();
          while(true) wordController.finder();
      }
  }