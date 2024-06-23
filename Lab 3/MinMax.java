import java.util.*;
public class MinMax {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int maxi=0;
        int mini=0;

        System.out.println("Enter the num:");
        int n=sc.nextInt();

        int[]arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0; i<n; i++){
            if(max<arr[i]){
                max=arr[i];
                maxi=i;
            }
        }
        for(int i=0; i<n; i++){
            if(min>arr[i]){
                min=arr[i];
                mini=i;
            }
        }

        System.out.println(maxi);
        System.out.println(mini);

        sc.close();
    }
    
}
