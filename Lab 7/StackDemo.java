import java.util.Scanner;
class StackImplement{
    int size;
    int top;
    int[] stackArray;

    public StackImplement(int size){
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

    public int peep(int i){
        if(top-i<0){
            System.out.println("StackUnderFlow");
            return -1;
        }
        else{
            return stackArray[top-i+1];
        }
    }

    public void change(int i, int newValue){
        if(top-i<0){
            System.out.println("Invalid Index");
        }
        else{
            stackArray[i]=newValue;
            System.out.println("Changed value at Order " + i + " to " + newValue);
        }
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
    
}
public class StackDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = sc.nextInt();
        StackImplement stack = new StackImplement(size);
        int choice;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. PEEP");
            System.out.println("4. CHANGE");
            System.out.println("5. DISPLAY");
            System.out.println("6. EXIT");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: System.out.print("Enter a value to push: ");
                        int value = sc.nextInt();
                        stack.push(value);
                        stack.display();
                        break;

                case 2: int poppedValue=stack.pop();
                        System.out.println("Pop Value: "+poppedValue);
                        stack.display();
                        break;

                case 3: System.out.println("Enter the i:");
                        int i=sc.nextInt();
                        int peepedValue=stack.peep(i);
                        System.out.println("Peep Value: "+peepedValue);
                        stack.display();
                        break;

                case 4: System.out.print("Enter the index to change: ");
                        int index = sc.nextInt();
                        System.out.print("Enter the new value: ");
                        int newValue = sc.nextInt();
                        stack.change(index, newValue);
                        stack.display();
                        break;
                
                case 5: stack.display();
                        break;

                case 6: System.out.println("Exiting...");
                        return;

                default:System.out.println("Invalid Choice");
                        break;
            }
        }
    }
}
