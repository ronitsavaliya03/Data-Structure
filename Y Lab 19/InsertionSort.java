import java.util.Scanner;

public class InsertionSort {
    public int[] insertionSort(int[] array){
        int i=1;

        while(i<array.length){
            int key=array[i];
            int j=i-1;

            while (i>=0 && array[j]>key) {
                array[j+1]=array[j];
                j--;
            }

            array[j+1]=key;
            i++;
        }
        return array;
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

        InsertionSort object=new InsertionSort();
        object.insertionSort(array);

        System.out.println("---------After Sort Display---------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(); 

    }
}
