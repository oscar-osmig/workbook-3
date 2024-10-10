package Mod01;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Store {
    // the key is the product id, the value is a product object
    public static HashMap<String, Product> inventory =
            new HashMap<String, Product>();
        public static void main(String[] args) throws IOException {
            // this method loads product objects into inventory
            loadInventory();
            Scanner scanner = new Scanner(System.in);
            System.out.print("What is the product?\n");
            String name = scanner.nextLine();
            Product matchedProduct = inventory.get(name);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                return;
            }
            System.out.printf("We carry %s and the price is $%.2f",
                    matchedProduct.getName(), matchedProduct.getPrice());
        }


    static String file_name = "inventory.csv";

    private static void loadInventory() throws IOException {
//        Map<String, Float> product_list = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file_name));

        String input;
        while((input = bufferedReader.readLine()) != null){ // while the line is not the last in file it continues
            String[] product = input.split(Pattern.quote("|")); // splits the lines by | and store each element in a string array
            Product product1 = new Product(Integer.parseInt(product[0]), product[1], Float.parseFloat(product[2])); // make a new product with the parts of the array we made
            inventory.put(product1.getName(), product1); // adding new product to the 'inventory' list
        }

    }
}