import java.util.*;
public class AdditionOfMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the value of m:");
        int m=sc.nextInt();
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();

        int array1[][]=new int[m][n];
        int array2[][]=new int[m][n];
        int array3[][]=new int[m][n];

        for(int i=0; i<array1.length; i++){
            for(int j=0; j<array1.length; j++){
                array1[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<array2.length; i++){
            for(int j=0; j<array2.length; j++){
                array2[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<array2.length; i++){
            for(int j=0; j<array2.length; j++){
                array3[i][j]=array1[i][j]+array2[i][j];
            }
        }

        System.out.println("--------------------------------------");
        for(int i=0; i<array2.length; i++){
            for(int j=0; j<array2.length; j++){
                System.out.print(array3[i][j]+"  ");
            }
            System.out.println("");
        }





    }
    
}                       
