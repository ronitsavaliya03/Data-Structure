import java.util.Scanner;
import java.util.Stack;

public class EvaluatePrefix{
    public int performOperation(int a, int b,char c){
        int value;
        switch(c){
            case '+':  value=a+b;
                       return value;
            case '-':  value=a-b;
                       return value;
            case '*':  value=a*b;
                       return value;
            case '/':  value=a/b;
                       return value;
            case '^':  value=a^b;
                       return value;
            default:
                       return 0;

        }
    }
    public boolean checkFirstChar(String infix){
        String v="+-*/^";

        char c=infix.charAt(0);
        if(v.indexOf(c) != -1){
            return true;
        }
    
        return false;
    }

    public boolean checkPrefix(String infix){
        int rank=0;

        for(char ch: infix.toCharArray()){
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
                rank--;
            }
            else{
                rank++;
            }
        
        }

        if(rank==1 && checkFirstChar(infix)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        EvaluatePrefix ep=new EvaluatePrefix();
        Stack<Integer> stack=new Stack<>();

        System.out.println("Enter the Prefix Expression: ");
        String infix=sc.nextLine();

        if(!ep.checkPrefix(infix)){
            System.out.println("Expression is InValid");
            System.exit(1);
        }

        for(int i = infix.length()-1; i >= 0; i--){
            if(Character.isDigit(infix.charAt(i))){
                stack.push(Integer.parseInt(Character.toString(infix.charAt(i))));
            }
            else{
                int op1=stack.pop();
                int op2=stack.pop();

                int value=ep.performOperation(op1,op2,infix.charAt(i));
                stack.push(value);
            }
        }

        int ans=stack.pop();
        System.out.println("Answer: "+ans);

    }
}
