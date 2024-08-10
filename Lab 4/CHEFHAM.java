import java.util.Scanner;
import java.util.Arrays;

public class CHEFHAM {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Size of Array:");
        int n=sc.nextInt();

        int[] A=new int[n];

        System.out.println("Make Chef's Array:");
        for(int i=0; i<n; i++){
            A[i]=sc.nextInt();
        }

        System.out.println("Chef's Array A:");
        for(int i=0; i<n; i++){
            System.out.print(A[i]+" ");
        }

        int[] B=A.clone();
        Arrays.sort(B);

        for(int i=0; i<n; i++){
            if(A[i]==B[i]){
                if(B[0] == A[0]) {
                    int temp = B[0];
                    B[0] = B[n - 1];
                    B[n - 1] = temp;
                }else if(i<n-1 && B[i]!=B[i+1]){
                    int temp=B[i];
                    B[i]=B[i+1];
                    B[i+1]=temp;
                }else{
                    int temp=B[i];
                    B[i]=B[i-1];
                    B[i-1]=temp;
                }
            }
        }

        System.out.println();
        System.out.println("Chef's little brother's Array B:");
        for(int i=0; i<n; i++){
            System.out.print(B[i]+" ");
        }

        sc.close();
    }
    
}
