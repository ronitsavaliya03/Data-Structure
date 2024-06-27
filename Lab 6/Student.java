import java.util.*;
public class Student {
    public static void main(String[] args) {
        Student_Detail []Student= new Student_Detail[2];

        for(int i=0; i<Student.length; i++){
            Student[i] = new Student_Detail();
            Student[i].setDetails();
            Student[i].getDetails();
        }

    }
}
class Student_Detail{
    int Enrollment_No;
    String Name;
    int Semester;
    double CPI;

    void setDetails(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Enrollment No.:");
        Enrollment_No=sc.nextInt();
        System.out.println("Enter the Name of Student:");
        Name=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the Semester:");
        Semester=sc.nextInt();
        System.out.println("Enter the CPI: ");
        CPI=sc.nextDouble();
    }

    void getDetails(){
        System.out.println("---------Student Details----------");
        System.out.println("Studennt ID: "+Enrollment_No);
        System.out.println("Name: "+Name);
        System.out.println("Semeter: "+Semester);
        System.out.println("CPI: "+CPI);
        System.out.println("----------------------------------");
    }
}