import java.util.*;
public class Temprature {
    void celsiustoFahrenhit(){
        Scanner sc=new Scanner(System.in);
        double F=sc.nextDouble();

        double C = (F - 32) * 5/9;
        System.out.println(F+" F"+" ="+C+" C");
    }
    void fahrenhittoCelsius(){
         Scanner sc=new Scanner(System.in);
         double C=sc.nextDouble();

         double F = (C * 9/5) + 32;
         System.out.println(F+" F"+" ="+C+" C");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter 1 for Celsius to Fahrenhit:\nEnter 2 for fahrenhit to Celsius:");
        int check=sc.nextInt();

        Temprature T=new Temprature();

        if(check==1){
            T.celsiustoFahrenhit();
        }else if(check==2){
            T.fahrenhittoCelsius();
        }
        sc.close();   
    }
}
