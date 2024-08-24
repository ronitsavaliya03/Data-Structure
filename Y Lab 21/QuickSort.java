import java.util.Scanner;

public class QuickSort {
    public void quickSort(int[] array,int LB,int UB){
        int i,j;

        if(LB<UB){
            i=LB;
            j=UB;
            int key=array[LB];

            while(i<j) {
                while(i<UB && array[i]<=key){
                    i++;
                }
                while (j>LB && array[j]>key) {
                    j--;
                }
                if (i<j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

                int temp=array[LB];
                array[LB]=array[j];
                array[j]=temp;

            quickSort(array,LB,j-1);
            quickSort(array,j+1,UB);
        }
    }
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n=sc.nextInt();

        int[] array=new int[n];
        int LB=0;
        int UB=array.length-1;

        System.out.println("Enter the element: ");
        for(int i=0; i<array.length; i++){
            array[i]=sc.nextInt();
        }

        System.out.println("---------------Display---------------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        QuickSort object=new QuickSort();
        object.quickSort(array,LB,UB);

        System.out.println("---------After Sort Display---------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(); 

        sc.close();
    }
}
