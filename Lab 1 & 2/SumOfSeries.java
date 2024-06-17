import java.util.*;
public class SumOfSeries {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int sum=0;

        for(int i=1; i<=n; i++){

            System.out.print("(");

            for(int j=1; j<=i; j++){
                System.out.print(j+"+");
                sum+=j;
            }

            System.out.print("\b");
            System.out.print(")+");

        }
        System.out.println("\b");

        System.out.print("Answer: "+sum);

        sc.close();
    }
    
}
