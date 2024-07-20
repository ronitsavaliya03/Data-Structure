import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix{
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
            return false;
        }
    
        return true;
    }

    public boolean checkPostfix(String infix){
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
        EvaluatePostfix ep=new EvaluatePostfix();
        Stack<Integer> stack=new Stack<>();

        System.out.println("Enter the Postfix Expression: ");
        String infix=sc.nextLine();

        if(!ep.checkPostfix(infix)){
            System.out.println("Expression is InValid");
            System.exit(1);
        }

        for(char i: infix.toCharArray()){
            if(Character.isDigit(i)){
                stack.push(Integer.parseInt(Character.toString(i)));
            }
            else{
                int op2=stack.pop();
                int op1=stack.pop();

                int value=ep.performOperation(op1,op2,i);
                stack.push(value);
            }
        }

        int ans=stack.pop();
        System.out.println("Answer: "+ans);

    }
}