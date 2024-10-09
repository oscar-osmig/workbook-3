package Mod01;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreApp {
//    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        ArrayList<Product> inventory = getInventory(); // makes a list type Product and assigns the return of GetInventory()
        //Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
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
        BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv")); // reads lines in provided file
    //        bufferedReader.readLine();
        String input;

        while((input = bufferedReader.readLine()) != null){ // while the line is not the last in file it continues
            String[] product = input.split(Pattern.quote("|")); // splits the lines by | and store each element in a string array
            Product product1 = new Product(Integer.parseInt(product[0]), product[1], Float.parseFloat(product[2])); // make a new product with the parts of the array we made
            inventory.add(product1); // adding new product to the 'inventory' list
        }
        return inventory;
    }
}


