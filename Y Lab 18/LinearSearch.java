import java.util.*;
public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n=sc.nextInt();

        int[] array=new int[n];

        System.out.println("Enter the element: ");
        for(int i=0; i<array.length; i++){
            array[i]=sc.nextInt();
        }

        System.out.println("--------------Display--------------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        System.out.println("Enter the element you want to search:");
        int search=sc.nextInt();


        boolean flag=false;
        for(int i=0; i<array.length; i++){
            if(array[i]==search){
                if(i%10==1){
                    System.out.println(array[i]+" is at "+i+"st index");
                }else if(i%10==2){
                    System.out.println(array[i]+" is at "+i+"nd index");
                }else if(i%10==3){
                    System.out.println(array[i]+" is at "+i+"rd index");
                }else{
                    System.out.println(array[i]+" is at "+i+"th index");
                }
                flag=true;
            }
        }

        if(!flag){
            System.out.println("Element is not Found");
        }
    }
}
