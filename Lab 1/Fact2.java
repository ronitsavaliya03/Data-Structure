import java.util.*;
public class Fact2 {
    class Factorial{
        static int fact(int n){
            if(n==0 || n==1){
                return 1;
            }
            else{
                return (n * fact(n-1));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int f=Factorial.fact(n);
        System.out.println("factorial of "+n+" is "+f);
        sc.close();
    }
    
}
