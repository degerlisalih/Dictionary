    /*
     * %W% %E% salih DEĞERLİ
     *
     * The purpose of this simple program is to easily find the English equivalent of Turkish words.
     *
     */
    package examples.com;

    import java.io.BufferedReader;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Scanner;

    /**
     * class has two methods.One of them is main and the other is finder.
     * this is a single class and it is doing all job.
     *
     * @author Salih DEĞERLİ
     * @version 1.0.1  11 Oct 2020
     */
    public class Dictionary {

        public static void main(String[] args) {
            /*This method finds txt file and it sends the reader to finder method*/
            try {

                FileReader fileReader = new FileReader("words.txt");
                BufferedReader reader = new BufferedReader(fileReader);
                finder(reader);

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("exception!! : " + fileNotFoundException);
            }

        }

        public static void finder(BufferedReader reader) {
            /*this method reads the words.txt file and export the words. It has a controller loop*/
            Scanner scanner = new Scanner(System.in);

            boolean controller; /* checking the presence of a word*/
            String line;

            System.out.println("system exit key : exit");

            while (true) {

                controller = false;

                System.out.print("enter a word : ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                try {
                    while ((line = reader.readLine()) != null) {
                        String[] words = line.split(" = ");

                        if (words[0].equalsIgnoreCase(input)) {
                            System.out.println(words[1]);
                            controller = true;
                            break;
                        }
                    }

                    if (!controller) System.out.println("object not found");

                    /*reader was reset */
                    reader.close();
                    reader = new BufferedReader(new FileReader("words.txt"));

                } catch (IOException ioException) {
                    System.out.println("exception!! : "+ioException);
                }

            }
            scanner.close();
        }
    }
