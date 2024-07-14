import java.util.*;
public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of cases: ");
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++){
            String input=sc.nextLine();
            System.out.println(isBalanced(input)?1:0);
        }

        sc.close();
    }

    public static boolean isBalanced(String str){
        Stack<Character> stack=new Stack<>();
    
        for(char c: str.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else if(c==')' || c=='}' || c==']'){
                if(stack.isEmpty()){
                    return false;
                }
    
                char top=stack.pop();
                if((c==')' && top!='(') || (c=='}' && top!='{') || (c==']' && top!='[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
}
