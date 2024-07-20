import java.util.*;
import java.util.Stack;
public class InfixToPrefix {
    public static void main(String[] args) {
        
        Prefix object=new Prefix();
        object.convert();
    }
}
class Prefix{
    public int inputPrecedence(char ch){
        switch(ch){
            case '+':
            case '-':
                    return 2;
                    
            case '*':
            case '/':
                    return 4;

            case '^':
                    return 5;

            case '(':
                    return 9;
                  
            case ')':
                    return 0;

            default: return 7;
        }
    }

    public int stackPrecedence(char ch){

        switch(ch){
            case '+':
            case '-':
                    return 1;
                    
            case '*':
            case '/':
                    return 3;

            case '^':
                    return 6;

            case '(':
                    return 0;
    
            default: return 8;

        }
    }

    public int checkRank(char ch){

        if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
            return -1;
        }
    
        return 1;

    }

    public void convert(){
        Scanner sc=new Scanner(System.in);
        Stack<Character> stack=new Stack<>();

        System.out.println("Enter the Infix Notation: ");
        String infix=sc.nextLine();

        String polish="";
        int rank=0;
        String reverseInfix="";

        for(int i=infix.length()-1;i>=0;i--){
            
            if(infix.charAt(i)==')'){
                reverseInfix+='(';
            }
            else if(infix.charAt(i)=='('){
                reverseInfix+=')';
            }
            else{
                reverseInfix+=infix.charAt(i);
            }
        }

        reverseInfix += ')';

        stack.push('(');
       
       for(char c : reverseInfix.toCharArray()){
            if(stack.isEmpty()){
                System.out.println("Invalid.!!");
                return;
            }
            
            while(stackPrecedence(stack.peek()) > inputPrecedence(c)){
                char temp=stack.pop();
                polish+=temp;
                rank+=checkRank(temp);

                if(rank<1){
                    System.out.println("Invalid");
                    return;
                }

            }

            if(stackPrecedence(stack.peek()) != inputPrecedence(c)){
                stack.push(c);
            }
            else{
                stack.pop();
            }

       }

       String reversePolish="";
       for(int i=polish.length()-1;i>=0;i--){
            
        if(polish.charAt(i)==')'){
            reversePolish+='(';
        }
        else if(polish.charAt(i)=='('){
            reversePolish+=')';
        }
        else{
            reversePolish+=polish.charAt(i);
        }
    }

    

       if(rank!=1){
            System.out.println("Invalid");
       }
       else{
          System.out.println("Valid");
       }


       System.out.println("Infix: "+infix);
       System.out.println("Prefix: "+reversePolish);
       System.out.println("Rank: "+rank);

    }
}

