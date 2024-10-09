package Mod01;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Story {

        public static void main(String[] args) {

            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Select story to read: \n 1. goldilocks \n 2. hansel_and_gretel\n 3. mary_had_a_little_lamb");
                String choice = scanner.nextLine().trim();
                FileInputStream fis = new FileInputStream(choice);
                Scanner storyScanner = new Scanner(fis);
                String input;
                int line_count = 1;
                while (storyScanner.hasNextLine()) {
                    input = storyScanner.nextLine();
                    System.out.println(line_count + ". " + input);
                    line_count++;
                }
                storyScanner.close();
                fis.close();
                scanner.close();
            } catch (IOException e) {
                System.out.println("Problem:" + e.getMessage());
            }
        }
}