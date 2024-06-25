import java.util.*;
public class InsertInSorted {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Array[]={1,2,4,5,6};
        int j=0;
        System.out.println("Enter the Element:");
        int element=sc.nextInt();

        int NewArray[]=new int[Array.length+1];
        int index=0;
        for(int i=0; i<Array.length-1;i++){
            if(Array[i]<element && Array[i+1]>element){
                index=i+1;
            }
        }

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
