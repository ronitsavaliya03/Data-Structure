import java.util.Scanner;
import java.util.*;
public class MinStack {
    int size;
    int top;
    int[] stackArray;

    public MinStack(int size){
        this.size=size;
        this.top=-1;
        stackArray=new int[size];
    }

    public void push(int value){
        if(top>=stackArray.length-1){
            System.out.println("StackOverFlow");
        }
        else{
            top++;
            stackArray[top]=value;
        }
    }

    public int pop(){
        if(top<0){
            System.out.println("StackUnderFlow");
            return -1;
        }
        else{
            return stackArray[top--];
        }
    }

    public int top(){
        if(top<0){
            System.out.println("StackUnderFlow");
            return -1;
        }
        else{
            return stackArray[top];
        }
    }

    public int getMin(){
        int min=Integer.MAX_VALUE;
        for(int i=top; i>=0; i--){
            if(min>stackArray[i]){
                min=stackArray[i];
            }
        }
        return min;
    }

    public void display(){
        if (top<0) {
            System.out.println("StackUnderFlow");
        }
        else{
            System.out.println("Stack elements are:");
            for (int i = top; i >= 0; i--) {
                System.out.println("| "+stackArray[i]+" |");
            }
            System.out.println("|____|");
        }
    }

    public static void main(String[] args) {
            String[] operations = {"MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"};
            int[][] values = {{}, {-2}, {0}, {-3}, {}, {}, {}, {}};
        
            ArrayList<String> results = new ArrayList<>();
            MinStack minStack = null; 
        
            for (int i = 0; i < operations.length; i++) {
                String operation = operations[i];
        
                switch (operation) {
                    case "MinStack":
                        minStack = new MinStack(100); 
                        results.add("null"); 
                        break;
                    case "push":
                        minStack.push(values[i][0]);
                        results.add("null"); 
                        break;
                    case "pop":
                        minStack.pop();
                        results.add("null"); 
                        break;
                    case "top":
                        int topValue = minStack.top();
                        results.add(String.valueOf(topValue)); 
                        break;
                    case "getMin":
                        int minValue = minStack.getMin();
                        results.add(String.valueOf(minValue)); 
                        break;
                    default:
                        System.out.println("Invalid operation: " + operation);
                        break;
                }
            }
        
            System.out.println(results);

    }
}
