package Mod01;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreApp {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ArrayList<Product> inventory = getInventory();
        //Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f \n",
                    p.getId(), p.getName(), p.getPrice());

        }
    }
    public static ArrayList<Product> getInventory() throws IOException {
        ArrayList<Product> inventory = new ArrayList<Product>();
    // this method loads product objects into inventory
    //        inventory.add(new Product(123, "phone", 333.3f));
    // and its details are not shown
        BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
    //        bufferedReader.readLine();
        String input;

        while((input = bufferedReader.readLine()) != null){
            String[] product = input.split(Pattern.quote("|"));
            Product product1 = new Product(Integer.parseInt(product[0]), product[1], Float.parseFloat(product[2]));
            inventory.add(product1); // adding new product to the 'inventory' list
        }
        return inventory;
    }
}


