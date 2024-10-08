package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    static Scanner scanner = new Scanner(System.in);
    static boolean run = true;
    static String[] quotes = {"1.Can you goback in time? no!, jump to the future? no! but you can learn from the past and fix your future",
            "2. If you took the time to breathe when you're stressed you wouldnt be stressed!",
            "3. if life is unfair to everyone, then is life fair?",
            "4. If you could travel anywhere you'd eventually travel there",
            "5. Your worst anemy is your conciousness",
            "6. Being alive is both a curse and gift",
            "7. Happiness cant exist without sadness",
            "8. Money cant buy happiness, but it'd make me happy buying a furry cow",
            "9. Why think sad things? when you can just not think at all!",
            "10. I'll give you a reason to cry for real!"};

    public static void quotes(Scanner scanner)
    {
        random_quote(scanner, quotes);
        System.out.println("\n                                              ***** QUOTES *****                                              \n");

    }

    public static void random_quote(Scanner scanner, String[] quotes)
    {
        int random = (int) (Math.random()* 10) + 1; // gives a random number in between 10
        System.out.println("Do you want a random quote? (y/n)");
        String choice = scanner.nextLine();

        switch (choice)
        {
            case "y":
                System.out.println(quotes[random]);
                break;
            case "n":  // if not wanted random quote ill will execute the list of quotes
                not_random(scanner, quotes);
        }

    }

    public static void not_random(Scanner Scanner, String[] quote)
    {
//        for (String phrase : quotes) // display each quote
//        {
//            System.out.println(phrase);
//        }
        System.out.println("\nPlease select between 1 - 10:"); // takes in user input
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 10 || choice < 1) // throws error in case the input is out of range
        {
            throw new RuntimeException("Choice out of bounce!");
        }

        switch (choice) { // checks if inpur is the same as a case in list
            case 1:
                System.out.println(quotes[0]);
                break;
            case 2:
                System.out.println(quotes[1]);
                break;
            case 3:
                System.out.println(quotes[2]);
                break;
            case 4:
                System.out.println(quotes[3]);
                break;
            case 5:
                System.out.println(quotes[4]);
                break;
            case 6:
                System.out.println(quotes[5]);
                break;
            case 7:
                System.out.println(quotes[6]);
                break;
            case 8:
                System.out.println(quotes[7]);
                break;
            case 9:
                System.out.println(quotes[8]);
                break;
            case 10:
                System.out.println(quotes[9]);
                break;
        }
    }


        public static void main (String[]args)
        {

            do { // it executes the block of code at least once
                quotes(scanner); // containts the functions which display random or list of quotes
                System.out.println("Do you want to continue? (y/n)");
                String choice = scanner.nextLine();
                switch (choice) { // validates choice
                    case "n":
                        run = false; // will breeak while loop
                        System.out.println("\nTill next time!");
                        break;
                }
            } while (run); // will execute block of code unless its false
        }
    }

