import java.util.*;
public class MergeSort {
    public int[] mergeSort(int[] array,int low,int high){
        if(low<high){
            int mid=((low+high)/2);

            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);

            merge(array,low,mid,high);

        }
        return array;
    }

    public int[] merge(int[]array, int low, int mid, int high){
        int i,j,k,h;
        int[] temp=new int[array.length];

        h=low;
        i=low;
        j=mid+1;

        while (h<=mid && j<=high){
            if(array[h]<=array[j]){
                temp[i]=array[h];
                h++;
            }else{
                temp[i]=array[j];
                j++;
            }
        
            i++;
        }

        if(h>mid){
            for(k=j; k<=high; k++){
                temp[i]=array[k];
                i++;
            }
        }else{
            for(k=h; k<=mid; k++){
                temp[i]=array[k];
                i++;
            }
        }

        for(k=low; k<=high; k++){
            array[k]=temp[k];
        }

        return array;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n=sc.nextInt();

        int[] array=new int[n];
        int low=0;
        int high=array.length-1;

        System.out.println("Enter the element: ");
        for(int i=0; i<array.length; i++){
            array[i]=sc.nextInt();
        }

        System.out.println("---------------Display---------------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        MergeSort object=new MergeSort();
        object.mergeSort(array,low,high);

        System.out.println("---------After Sort Display---------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(); 

    }
}
