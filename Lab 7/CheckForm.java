import java.util.*;
class Stack{
    int size;
    int top;
    int[] stackArray;

    public Stack(int size){
        this.size=size;
        this.top=-1;
        stackArray=new int[size];
    }

    public void push(int value) {
        // condition top>stackArray.length
        if (top >= stackArray.length - 1) {
            System.out.println("StackOverFlow");
        } else {
            top++;
            stackArray[top] = value;
        }
    }
}

public class CheckForm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String(Please enter Space(_) at the last: )");
        String s = sc.nextLine();
        int i = 0;

        Stack aStack = new Stack(s.length());
        Stack bStack = new Stack(s.length());

        char next = s.charAt(i);

        while (next != ' ') {
            if (s.charAt(i) == 'a') {
                aStack.push(1);
            } else if (s.charAt(i) == 'b') {
                bStack.push(0);
            }
            next = s.charAt(i++);
        }

        if(aStack.top==bStack.top){
            System.out.println("Valid String.");
        }
        else{
            System.out.println("Invalid String.");
        }
     
        sc.close();
    }
}