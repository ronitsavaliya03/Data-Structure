import java.util.*;
public class Vowel {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        char ch=sc.next().charAt(0);
        String s="aeiouAEIOU";

        if(s.indexOf(ch)>-1){
            System.out.println("Vowel");
        }
        else{
            System.err.println("Not a Vowel");
        }
        sc.close();
    }
    
}
