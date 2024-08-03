import java.util.*;
public class BinarySearch {

    public int binarySearchRecursive(int[] array,int left,int right,int search){
        if(left>right){
            return -1;
        }

        int mid=left+(right-left)/2;

        if(array[mid]==search){
            return mid;
        }else if(array[mid]>search){
            return binarySearchRecursive(array, left, mid-1, search);
        }else{
            return binarySearchRecursive(array, mid+1, right, search);
        }
    }

    public int binarySearch(int[] array,int search){
        int left=0;
        int right=array.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(array[mid]==search){
                return mid;
            }else if(array[mid]>search){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    public int[] sort(int[] array){
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

        BinarySearch object=new BinarySearch();
        object.sort(array);

        System.out.println("--------------Display--------------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        int left=0;
        int right=array.length-1;
        
        System.out.println("Enter the element you want to search:");
        int search=sc.nextInt();


        //As Iterative
        System.out.println("Method 1: Iterative");
        int result1 = object.binarySearch(array, search);

        if(result1!=-1){
            System.out.println(array[result1]+" at "+result1);
        }else{
            System.out.println("Element is not Found");
        }



        //As Recursive
        System.out.println("Method 2: Recursive");
        int result2 = object.binarySearchRecursive(array, left, right, search);

        if(result2!=-1){
            System.out.println(array[result2]+" at "+result2);
        }else{
            System.out.println("Element is not Found");
        }

        sc.close();
    }
}
