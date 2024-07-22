import java.util.*;
class MyQueue{
    int[] queue;
    int rear;
    int front;
    int size;

    MyQueue(int size){
        this.size=size;
        this.queue=new int[size];
        this.front=-1;
        this.rear=-1;
    }

    public void enqueue(int x){
        if(rear==size-1){
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if(front==-1){
            front=0;
        }
        queue[++rear]=x;
    }

    public void dequeue(){
        if(front==-1){
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        if(front==rear){
            front=-1;
            rear=-1;
        }else{
            front++;
        }
    }

    public void display(){
        if(front==-1){
            System.out.println("Queue is empty.!");
            return;
        }

        System.out.println("Queue Elements: ");
        for(int i=front; i<=rear; i++){
            System.out.print(queue[i]+"...");
        }
        System.out.println();
    }
}
public class QueueDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = sc.nextInt();

        MyQueue queue = new MyQueue(size);

        while (true) {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. ENQUEUE");
            System.out.println("2. DEQUEUE");
            System.out.println("3. DISPLAY");
            System.out.println("4. EXIT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = sc.nextInt();
                    queue.enqueue(element);
                    queue.display();
                    break;
                case 2:
                    queue.dequeue();
                    queue.display();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(1);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
            
    }
    
}
