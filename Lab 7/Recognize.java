import java.util.Stack;
public class Recognize {
    
    public static void main(String[] args) {
        String string="aabcbaa ";
        Stack<Character> s = new Stack<>();
        int i=0;

        // s.push('c');
        char next= string.charAt(i++);

        while (next!='c'){
            if(next==' '){
                System.out.println("Invalid String."); 
                return;  
            }
            else{
                s.push(next);
                next= string.charAt(i++);
            }
        }

        System.out.println("Stack "+s+"\n-------------------------");

        while (!s.isEmpty()) {
            next=string.charAt(i++);
            char x=s.pop();

            if(next!=x){
                System.out.println("Invalid String.");
                return;
            }
            
        }

        next=string.charAt(i++);
        System.out.println("Entered String..:"+string);
        if(next==' '){
            System.out.println("Valid String.");
        }
        else{
            System.out.println("Invalid String.");
        }

    }
}
