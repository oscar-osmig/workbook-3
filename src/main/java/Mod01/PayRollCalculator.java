package Mod01;

import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayRollCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean prefered_extension = false;

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the name of file to process: (note: include extension)");
        String File= scanner.nextLine().trim();

        FileReader fileReader = new FileReader(File);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        System.out.println("Enter the name of the payroll file to create: (note: write only name)");
        String output_file = scanner.nextLine().trim();

        System.out.println("Do you want the extension to be '.json' (y/n)? (n -> default extension '.csv')");
        String extension_choice = scanner.nextLine();
        if(extension_choice.equals("y")){
            prefered_extension = true;
            output_file = output_file + ".json";
            System.out.println("Details from: " + File + " written to: " + output_file);
        }else{
            output_file = output_file + ".csv";
            prefered_extension = false;
            System.out.println("Details from: " + File + " written to: " + output_file);
        }


        BufferedWriter file_writer = new BufferedWriter(new FileWriter(output_file, true));
        if(prefered_extension == false){file_writer.write("id|name|grossPay\n");}

        String input;
        bufferedReader.readLine();// to ignore first line
        int count = 0;

        StringBuilder jsonContent = new StringBuilder();

        while((input = bufferedReader.readLine()) != null){

            String[] employee = input.split(Pattern.quote("|"));

            Employee employee1 = new Employee(employee[0], employee[1], Float.parseFloat(employee[2]) , Float.parseFloat(employee[3]));

            System.out.println( "Employee: " + employee1.getName() + " | " + " id: " + employee1.getEmployeeId() + " | " +
                                " Gross pay: " + NumberFormat.getCurrencyInstance().format(employee1.getGrossPay()) );

            if (prefered_extension == true) {

                if (count == 0) {jsonContent.append("[\n"); count++;}
                jsonContent.append(" { \"id\": " + employee1.getEmployeeId() + ", \"name\": \"" +  employee1.getName() + "\", \"grossPay\": " + employee1.getGrossPay() + " },\n");


            }else{
                jsonContent.append(employee1.getEmployeeId() + "|" + employee1.getName() + "|" + employee1.getGrossPay() + "\n");
            }

        }
        jsonContent.delete(jsonContent.length() - 2, jsonContent.length() );
        jsonContent.append("\n]");
        file_writer.write(jsonContent.toString());
        scanner.close();
        fileReader.close();
        file_writer.close();
    }
}
