package Mod01;

public class Employee {
    String employeeId;
    String name;
    float hoursWorked;
    float payRate;

    public int getGrossPay(){
        return (int) (this.hoursWorked * this.payRate);
    }


    public Employee(String id, String name, float hoursWorked, float payRate){
        this.employeeId = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }
}
