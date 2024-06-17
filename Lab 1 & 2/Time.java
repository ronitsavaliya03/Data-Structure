import java.util.*;
public class Time {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the second:");
        int second=sc.nextInt();
        int hour=0,minute=0;

        while (second>=60) {
            minute++;
            second-=60;
        }
        while (minute>=60) {
            hour++;
            minute-=60;
        }

        System.out.println(hour+":"+minute+":"+second);
        sc.close();

    }
    
}
