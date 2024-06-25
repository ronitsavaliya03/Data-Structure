import java.util.*;
public class ReplaceCase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the String:");
        String word=sc.nextLine();
        int temp=0;

        for(int i=0; i<word.length(); i++){
            if((int)word.charAt(i)>=65 && (int)word.charAt(i)<=90){
                temp=(int)word.charAt(i);
                temp+=32;
                System.out.print((char)temp);

            }
            
            if((int)word.charAt(i)>=97 && (int)word.charAt(i)<=122){
                temp=(int)word.charAt(i);
                temp-=32;
                System.out.print((char)temp);

            }

            if((int)word.charAt(i)==32){
                temp=(int)word.charAt(i);
                temp=32;
                System.out.print((char)temp);
            }
        }
        sc.close();
    }
}
