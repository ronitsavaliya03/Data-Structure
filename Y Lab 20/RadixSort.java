import java.util.Arrays;
import java.util.Scanner;
public class RadixSort {
    public int getMax(int[] array){
        int max=Integer.MIN_VALUE;

        for(int i=0; i<array.length; i++){
            if(max<array[i]){
                max=array[i];
            }
        }

        return max;
    }

    public void countingSort(int[] array, int exp){
        int n =array.length;
        int[] output=new int[n];
        int[] count=new int[10];

        Arrays.fill(count, 0);

        for(int i=0; i<n; i++){
            int index= (array[i] / exp) % 10;
            count[index]++;
        }

        for(int i=1; i<10; i++){
            count[i]+=count[i-1];
        }

        for(int i=n-1; i>-1; i--){
            int index= (array[i] / exp) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
        }

        for(int i=0; i<n; i++){
            array[i]=output[i];
        }
    }

    public void radixSort(int[] array){
        int max=getMax(array);

        for(int exp=1; max/exp>0; exp*=10){
            countingSort(array, exp);
        }
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

        RadixSort object=new RadixSort();
        object.radixSort(array);

        System.out.println("---------After Sort Display---------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(); 

        sc.close();
    }
}
