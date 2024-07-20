import java.util.*;
import java.util.Stack;
public class InfixToPostfix {
    public static void main(String[] args) {

        Postfix object=new Postfix();
        object.convert();
        
    }
    
}
class Postfix{
    public int inputPrecedence(char ch){
        
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
                    return 2;
                    
            case '*':
            case '/':
                    return 4;

            case '^':
                    return 5;

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

        infix += ')';
        String polish="";
        int rank=0;

       
        stack.push('(');
       
       for(char c : infix.toCharArray()){
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

       if(rank!=1){
            System.out.println("Invalid");
       }
       else{
          System.out.println("Valid");
       }

    
       System.out.println("Infix: "+infix);
       System.out.println("Postfix: "+polish);
       System.out.println("Rank: "+rank);

    }
}
