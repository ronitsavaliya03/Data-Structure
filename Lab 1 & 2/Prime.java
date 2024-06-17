import java.util.*;
public class Prime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number:");
        int n=sc.nextInt();
        int count=2;

        for(int i=2; i<=n/2; i++){
            if(n%i==0){
                count++;
            }
        }

        if(count==2){
            System.out.println("Number is Prime");
        }
        else{
            System.out.println("Number is Not Prime");
        }
        sc.close();

    }
    
}
