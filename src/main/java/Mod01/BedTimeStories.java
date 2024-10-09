package Mod01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedTimeStories {
    private static final Scanner scanner = new Scanner(System.in);

    public static void read_file(String file) throws FileNotFoundException {
      FileInputStream read = new FileInputStream(file);
      Scanner scanner = new Scanner(read);
      String input;
      int line_counter = 1;
      System.out.println("\n-------------------------------------- " + file + " --------------------------------------\n");
      while(scanner.hasNextLine()){
          input = scanner.nextLine();
          System.out.println(line_counter + ". " + input);
          line_counter++;
      }
      scanner.close();

    }

    public static void main(String[] args) {

        try {
            System.out.println("\n\nPlease choose a story to read: \n1. goldilocks \n2. hansel and gretel \n3. Mary had a little lamb");
            int input = scanner.nextInt();
            scanner.close();
            switch (input) {
                case 1:
                    read_file("goldilocks.txt");
                    break;
                case 2:
                    read_file("hansel_and_gretel.txt");
                    break;
                case 3:
                    read_file("mary_had_a_little_lamb.txt");
                    break;
            }
            scanner.close();
        } catch (Exception e) {
            throw new RuntimeException("Choice out of bound!");
        }
    }
}
