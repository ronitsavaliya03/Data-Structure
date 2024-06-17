import java.util.*;
public class Power {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the base:");
        int n=sc.nextInt();
        System.out.println("Enter the power:");
        int p=sc.nextInt();
        double power=1;

        for(int i=1;i<=p;i++){
            power*=n;
        }

        System.out.println(power);
        sc.close();
    }
    
}
