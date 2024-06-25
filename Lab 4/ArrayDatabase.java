import java.util.Scanner;

public class ArrayDatabase{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array");          
        int n= sc.nextInt();

        int array[]=new int[n];

        System.out.println("Enter elements of array");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }

        int sum=0;
        int min=array[0];
        int max=array[0];
        for(int i=0;i<n;i++){
            sum+=array[i];
            if(array[i]<min){
                min=array[i];
            }
            if(array[i]>max){
                max=array[i];
            }
        }

        System.out.println("Sum = "+sum);
        System.out.println("Avg = "+(double)sum/n);
        System.out.println("Min = "+min);
        System.out.println("Max = "+max);

        sc.close();
    }
}