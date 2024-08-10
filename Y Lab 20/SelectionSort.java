import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n=sc.nextInt();

        int[] array=new int[n];

        System.out.println("Enter the element: ");
        for(int i=0; i<array.length; i++){
            array[i]=sc.nextInt();
        }

        System.out.println("-----------------Display------------------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        for(int i=0; i<array.length-1; i++){
            int min=i;

            for(int j=i+1; j<array.length; j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }

                int temp=array[min];
                array[min]=array[i];
                array[i]=temp;

        }

        System.out.println("--------------Display After Sort--------------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
