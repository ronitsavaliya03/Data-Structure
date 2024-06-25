import java.util.*;
public class DeleteElement {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the Index:");
        int index=sc.nextInt();

        int Array[]={1,2,3,4,5};

        int NewArray[]=new int[Array.length-1];
        int j=0;

        for(int i=0; i<index;i++){
            NewArray[j]=Array[i];
            j++;
        }
        for(int i=index+1; i<NewArray.length; i++){
            NewArray[j]=Array[i];
            j++;
        }
        System.out.println("-------------------------------");
        for(j=0; j<NewArray.length; j++)
            { 
                System.out.println(NewArray[j]);
            }
             
        sc.close();

    }
    
}
