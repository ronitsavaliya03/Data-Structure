import java.util.Scanner;

public class CountingSort {
    public int[] countingSort(int[] A){

        int max=0;
        for(int i=0; i<A.length; i++){
            if(A[i]>max){
                max=A[i];
            }
        }

        int[] C=new int[max+1];
        for(int i=0; i<=max; i++){
            C[i]=0;
        }

        for(int i=0; i<A.length; i++){
            C[A[i]]++;
        }

        for(int i=1; i<=max ;i++){
            C[i]+=C[i-1];
        }

        int[] B=new int[A.length];
        for(int i=A.length-1; i>=0; i--){
            B[C[A[i]]-1]=A[i];
            C[A[i]]--;
        }

        return B;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n=sc.nextInt();

        int[] array=new int[n];

        System.out.println("Enter the element: ");
        for(int i=0; i<array.length; i++){
            array[i]=sc.nextInt();
        }

        System.out.println("---------------Display---------------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        CountingSort object=new CountingSort();
        int[] sortedArray=object.countingSort(array);

        System.out.println("---------After Sort Display---------");
        for(int i=0; i<sortedArray.length; i++){
            System.out.print(sortedArray[i]+" ");
        }
        System.out.println(); 
        sc.close();
    }
}
