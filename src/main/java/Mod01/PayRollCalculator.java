package Mod01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.regex.Pattern;

public class PayRollCalculator {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("employees.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
        String input;
        input = bufferedReader.readLine(); // to ignore first line
        while((input = bufferedReader.readLine()) != null){

            bufferedReader.readLine();
            String[] employee = input.split(Pattern.quote("|"));

            float hours_worked = Float.parseFloat(employee[2]);
            float pay_rate = Float.parseFloat(employee[3]);

            Employee employee1 = new Employee(employee[0], employee[1], hours_worked , pay_rate);

            System.out.println( "Employee: " + employee1.getName() + " | " + " id: " + employee1.getEmployeeId() + " | " +
                                " Gross pay: " + NumberFormat.getCurrencyInstance().format(employee1.getGrossPay()) );
        }

    }
}
