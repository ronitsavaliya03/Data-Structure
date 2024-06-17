import java.util.*;
public class ConvertDays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Days:");
        int day=sc.nextInt();
        int week=0,year=0;

        while (day>=7) {
            week++;
            day-=7;
        }
        while (week>=(52)) {
            year++;
            week-=(52);
        }

        System.out.println(year+" years,"+week+" weeks,"+day+" days");
        sc.close();
    }
    
}
