import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PeacockFeathers {
    public static void main(String[] args) {
        Queue<String> feathers=new LinkedList<>(); 

        Scanner sc=new Scanner(System.in);
            
        System.out.println("Enter input separated by space : ");
        String input=sc.nextLine();

        String[] quaries=input.split(" ");

        for(String quary: quaries){
            if(quary.startsWith("buy_")){
                String color=quary.substring(4);
                feathers.add(color);
            }else if(quary.equals("fatch")){
                if(!feathers.isEmpty()){
                    String bottomFeather=feathers.poll();
                    System.out.println("Fetched: " + bottomFeather);
                    feathers.add(bottomFeather);
                }else{
                    System.out.println("No feathers to fetch.");
                }
            }
        }

        Stack<String> stack = new Stack<>();

        while (!feathers.isEmpty()) {
            stack.push(feathers.poll());
        }

        while (!stack.isEmpty()) {
            feathers.add(stack.pop());
        }

        for(String feather: feathers){
            System.out.println(feather);
        }
        sc.close();
    }
}
