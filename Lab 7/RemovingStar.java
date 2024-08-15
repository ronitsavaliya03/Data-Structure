import java.util.Scanner;
import java.util.Stack;
public class RemovingStar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        String string;
        String answer="";

        while(true){
            System.out.println("Enter the String:");
            string=sc.nextLine();

            if(string.charAt(0)=='*'){
                System.out.println("Invalid String Please try Again.");
            }else{
                break;
            }
        }

        Stack<Character> stack=new Stack<>();

        for(char ch: string.toCharArray()){
            if(ch=='*'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()){
            char ch=stack.pop();
            answer+=ch;
        }

        for(char ch: answer.toCharArray()){
            stack.push(ch);
        }

        String Ranswer="";
        while (!stack.isEmpty()){
            char ch=stack.pop();
            Ranswer+=ch;
        }

        System.out.println("After removing stars: "+Ranswer);
        sc.close();
    }
}
