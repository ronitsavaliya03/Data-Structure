import java.util.Scanner;

public class BubbleSort {
    public int[] bubblesort(int[] array){
        int last=array.length-1;

        for(int i=0; i<array.length-1; i++){
            int exchs=0;

            for(int j=0; j<last; j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;

                    exchs++;
                }
            }
            if(exchs==0){
                return array;
            }else{
                last--;
            }
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

        BubbleSort object=new BubbleSort();
        object.bubblesort(array);

        System.out.println("---------After Sort Display---------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

    }
    
}
