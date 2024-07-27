import java.util.Scanner;

class MyQueue{
    int[] queue;
    int size;
    int rear;
    int front;

    MyQueue(int size){
        this.size=size;
        this.queue=new int[size];
        this.rear=-1;
        this.front=-1;
    }

    public void insert(int y){
        if(rear==size-1){
            rear=0;
        }else{
            rear++;
        }

        if(front==rear){
            System.out.println("Overflow");
            return;
        }

        queue[rear]=y;

        if(front==-1){
            front=0;
            return;
        }
    }

    public int delete(){
        if(front==-1){
            System.out.println("Underflow");
            return 0;
        }

        int y=queue[front];

        if(front==rear){
            front=-1;
            rear=-1;
            return y;
        }

        if(front==size-1){
            front=0;
        }else{
            front++;
        }

        return y;
    }

    public void display(){
        if(front==-1){
            System.out.println("Queue is empty.!");
            return;
        }

        int i = front;
        while (true) {
            System.out.print(queue[i] + "...");
            if(i == rear){
                break;
            }
            i = (i+1) % size;
        }
        System.out.println();
    }
}
public class CircularQueue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = sc.nextInt();

        MyQueue queue = new MyQueue(size);

        while (true) {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. INSERT");
            System.out.println("2. DELETE");
            System.out.println("3. DISPLAY");
            System.out.println("4. EXIT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = sc.nextInt();
                    queue.insert(element);
                    queue.display();
                    break;
                case 2:
                    queue.delete();
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
