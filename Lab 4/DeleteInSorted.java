import java.util.*;
public class DeleteInSorted {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the element:");
        int element=sc.nextInt();

        int Array[]={1,2,4,5,6};

        int NewArray[]=new int[Array.length-1];
        int j=0;
        int index=0;
        int check=1;

        for(int i=0; i<Array.length; i++){
            if(element==Array[i]){
                index=i;
            }else{
                check=0;
                System.out.println("Invalid Value.!");
                break;
            }
        }

        for(int i=0; i<index; i++){
            NewArray[j]=Array[i];
            j++;
        }
        for(int i=index+1; i<Array.length; i++){
            NewArray[j]=Array[i];
            j++;
        }

        System.out.println("-------------------------------");
        if(check==1){
            for(j=0; j<NewArray.length; j++)
            { 
                System.out.println(NewArray[j]);
            }
        }else{
            System.out.println("Error..");
        }

        sc.close();
    }
    
}
