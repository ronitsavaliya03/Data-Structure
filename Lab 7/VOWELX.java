import java.util.Scanner;
import java.util.Stack;
public class VOWELX{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String question=sc.nextLine();
        String vowel="aeiouAEIOU";
        String answer="";

        Stack<Character> stack=new Stack<>();

        for(char ch: question.toCharArray()){

            if(vowel.indexOf(ch)>-1){
                answer="";
                while(!stack.isEmpty()){
                    answer+=stack.pop();
                }
                answer+=ch;
                for(char a: answer.toCharArray()){
                    stack.push(a);
                }
            }else{
                stack.push(ch);
            }

        }   


        StringBuilder temp = new StringBuilder();
            while(!stack.isEmpty() && vowel.indexOf(stack.peek()) < 0){
                temp.append(stack.pop());
            }

            answer += temp.reverse().toString();

        System.out.println(answer);
        sc.close();
    }
}