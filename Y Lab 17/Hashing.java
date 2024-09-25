import java.util.*;
import java.util.Arrays;

public class Hashing {
    public static void main(String[] args) {
        int[] array=new int[15];
        int[] hashTable=new int[20];

        Arrays.fill(hashTable, 0);

        Random random=new Random();

        for(int i=0; i<array.length; i++){
            array[i]=random.nextInt(100000, 999999);
        }

        System.out.println("Question Array:");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        System.out.println("\nIndeies Array:");
        for(int i=0; i<array.length; i++){
            int x=(array[i] % 18) + 2;
            System.out.print(x+" ");

            if(hashTable[x]!=0){
                while(hashTable[x]!=0){
                    x=(++x)%20;
                }
            }

            hashTable[x]=array[i];
        }

        System.out.println();
        System.out.println("\nHashing Table:");
        for(int i=0; i<hashTable.length; i++){
            System.out.print(hashTable[i]+" ");
        }
    }    
}
