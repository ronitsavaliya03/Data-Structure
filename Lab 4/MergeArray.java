import java.util.*;
public class MergeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int array1[] = new int[n];
        System.out.println("Enter the elements");
        for (int i=0; i<n; i++) {
            array1[i] = sc.nextInt();
        }

        System.out.println("Enter size of array");
        int m = sc.nextInt();
        int array2[] = new int[m];
        System.out.println("Enter the elements");
        for (int i=0; i<m; i++) {
            array2[i] = sc.nextInt();
        }

        int array3[] = new int[m + n];

        for (int i=0; i<m+n; i++) {
            if(i<n){
                array3[i] = array1[i];
            }
            else{
                array3[i] = array2[i-n];
            }
        }

        for (int i=0; i<m+n; i++) {
            System.out.print(array3[i] + " ");
        }
        sc.close();
    }
    
}
