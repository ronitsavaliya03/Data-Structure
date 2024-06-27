import java.util.*;
public class SwapNumbers {
    public void swapNumber(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Number 1:");
        int a=sc.nextInt();
        System.out.println("Enter the Number 2:");
        int b=sc.nextInt();

        System.out.println("Old: "+a+" "+b);

        int temp=a;
        a=b;
        b=temp;

        System.out.println("New: "+a+" "+b);
        sc.close();
    }
    public static void main(String[] args) {
        SwapNumbers q1=new SwapNumbers();
        q1.swapNumber();
    }
    
}
