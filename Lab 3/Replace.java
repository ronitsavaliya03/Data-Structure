import java.util.*;
public class Replace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array : ");
        int n = sc.nextInt();
        int[] array = new int[n];

        System.out.println("Enter an Elements : ");
        for(int i=0 ; i<n; i++){
            array[i] = sc.nextInt();
        }

        System.out.println("Enter first number :");
        int a = sc.nextInt();
        System.out.println("Enter second number : ");
        int b = sc.nextInt();

        int indexOfa=-1;
        int indexOfb=-1;

        for(int i=0; i<array.length; i++){
            if(a==array[i]){
                indexOfa=i;
            }
            else if(b==array[i]){
                indexOfb=i;
            }
        }

        if(indexOfa==-1 || indexOfb==-1){
            System.out.println("Element not found.!");
            System.exit(0);
        }

       
        System.out.print("Old : ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }
 
        int temp=array[indexOfa];
        array[indexOfa]=array[indexOfb];
        array[indexOfb]=temp;

        System.out.print("\nNew : ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }
        sc.close();
    }
}
