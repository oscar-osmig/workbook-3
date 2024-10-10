package Mod01;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreApp {
    public static Scanner scanner = new Scanner(System.in);
    private static boolean run = true;
    private static String file_name = "inventory.csv";

    public static void main(String[] args)  {

        try {
            System.out.println("\nWhat would you like to do?" +
                               "\n1- List all products" + "\n2- Look a product by its id" +
                               "\n3- Find all product within a price range" + "\n4- Add new product" +
                               "\n5- Quit the application" + "\nEnter command: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    display_all_products();
                    break;
                case 2:
                    find_product_by_id(scanner, getInventory());
                    break;
                case 3:
                    find_by_price_range(scanner, getInventory());
                    break;
                case 4:
                    add_new_product(scanner, getInventory());
                    break;
                case 5:
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void find_by_price_range(Scanner scanner, ArrayList<Product> inventory){
        System.out.println("\nPlease enter minimum price:");
        float min_price = scanner.nextFloat();
        System.out.println("\nPlease enter maximum price:");
        float max_price = scanner.nextFloat();
        System.out.println("\n---- product ranging between " + NumberFormat.getCurrencyInstance().format(min_price) + " - " + NumberFormat.getCurrencyInstance().format(max_price)  + " ----");
        for(Product product : inventory) {
            if(product.getPrice() >= min_price && product.getPrice() <= max_price) {
                //found it!
                System.out.println("\nid: " + product.getId() + "\nname: " + product.getName() +
                        "\nprice: " + NumberFormat.getCurrencyInstance().format(product.getPrice()));
            }
        }
    }


    public static void find_product_by_id(Scanner scanner, ArrayList<Product> inventory){
        System.out.println("\nPlease enter product id (note: case sensitive)\nProduct id:");
        int id = scanner.nextInt();
        for(Product product : inventory) {
            if(product.getId() == id) {
                //found it!
                System.out.println("------ product ------ \nid: " + product.getId() + "\nname: " + product.getName() +
                        "\nprice: " + NumberFormat.getCurrencyInstance().format(product.getPrice()));
            }
        }
    }

    public static void add_new_product(Scanner scanner, ArrayList<Product> inventory) throws IOException {

        System.out.println("\nPlease enter the following\nProduct id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nProduct name:");
        String name = scanner.nextLine();

        System.out.println("\nProduct Price:");
        float price = scanner.nextFloat();
        int counter = 0;
        BufferedWriter file_writer = new BufferedWriter(new FileWriter(file_name, true));
        for(Product product : inventory) {
            if(product.getId() != id) {
                //append new product to csv file
                if (counter == 0) {file_writer.write("\n" +id + "|" + name + "|" + price); counter++;}

            }
        }
        scanner.close();
        file_writer.close();
    }


    public static void display_all_products() throws IOException {
        ArrayList<Product> inventory = getInventory(); // makes a list type Product and assigns the return of GetInventory()
        //Scanner scanner = new Scanner(System.in);
        System.out.println("\nWe carry the following inventory:\n");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f \n",
                    p.getId(), p.getName(), p.getPrice());

        }
    }

    public static ArrayList<Product> getInventory() throws IOException { // returns a list type Product
        ArrayList<Product> inventory = new ArrayList<Product>(); // list of data type Product, list name 'inventory'
    // this method loads product objects into inventory
    //        inventory.add(new Product(123, "phone", 333.3f)); way to add product manually
    // and its details are not shown
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file_name)); // reads lines in provided file
    //        bufferedReader.readLine();
        String input;

        while((input = bufferedReader.readLine()) != null){ // while the line is not the last in file it continues
            String[] product = input.split(Pattern.quote("|")); // splits the lines by | and store each element in a string array
            Product product1 = new Product(Integer.parseInt(product[0]), product[1], Float.parseFloat(product[2])); // make a new product with the parts of the array we made
            inventory.add(product1); // adding new product to the 'inventory' list
        }
        Collections.sort(inventory, Comparator.comparing(Product::getName));
        return inventory;
    }
}


