// Create class Employee_Detail with attributes Employee_ID, Name, Designation, 
// and Salary. Write a program to read the detail from user and print it
import java.util.*;
public class Employee {
    public static void main(String[] args) {
        Employee_Detail employee1=new Employee_Detail();

        employee1.setDetails();
        employee1.getDetails();

    }
    
}
class Employee_Detail{
    int Employee_ID;
    String Name;
    String Designation;
    double Salary;

    void setDetails(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Employee_ID:");
        Employee_ID=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Name of Employee:");
        Name=sc.nextLine();
        System.out.println("Enter the Designation:");
        Designation=sc.nextLine();
        System.out.println("Enter the Salary:");
        Salary=sc.nextDouble();
    }

    void getDetails(){
        System.out.println("---------Employee Details----------");
        System.out.println("Employee ID: "+Employee_ID);
        System.out.println("Name: "+Name);
        System.out.println("Designation: "+Designation);
        System.out.println("Salary: "+Salary);

    }
}