import java.util.*;
public class InsertElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Index:");
        int index=sc.nextInt();
        System.out.println("Enter the Element:");
        int element=sc.nextInt();

        int Array[]={1,2,4,5,6};
        int j=0;

        int NewArray[]=new int[Array.length+1];

        for(int i=0; i<NewArray.length; i++){

            if(index==i){
                NewArray[i]=element;
                continue;
            }

            NewArray[i]=Array[j];
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