import java.util.*;
public class MutiplicationOfMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the value of m:");
        int m=sc.nextInt();
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();

        int array1[][]=new int[m][n];
        int array2[][]=new int[n][m];
        int array3[][]=new int[m][m];

        System.out.println("First Metrix:");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                array1[i][j]=sc.nextInt();
            }
        }

        System.out.println("Second Metrix:");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                array2[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<n; k++){
                    array3[i][j]+=array1[i][k]*array2[k][j];
                }
            }
        }

        System.out.println("--------------------------------------");
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                System.out.print(array3[i][j]+"  ");
            }
            System.out.println("");
        }

    }
    
}
