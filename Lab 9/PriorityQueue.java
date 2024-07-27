import java.util.*;
class PQueue{
    int[] queue;
    int rear;
    int front;
    int size;

    PQueue(int size){
        this.size=size;
        this.queue=new int[size];
        this.front=-1;
        this.rear=-1;
    }

    public void insert(int element){
        if(rear-front>=size-1){
            System.out.println("Overflow");
            return;
        }

        if (front == -1) { 
            front = rear = 0;
            queue[front] = element;
            return;
        }

        int i=rear;
        while(i>=0 && queue[i]>element){
            queue[i+1]=queue[i];
            i--;
        }

        queue[i+1]=element;
        rear++;
    }

    public int delete(){
        if(front==-1){
            System.out.println("'Underflow");
            return 0;
        }

        int i=front;
        int element=queue[front];
        while(i<rear){
            queue[i]=queue[i+1];
            i++;
        }

        // queue[i]=0;

        if(front==rear){
            front=rear=-1;
        }else{
            rear--;
        }
        return element;
    }

    public void display(){
        if (front == -1) { 
            System.out.println("Empty Queue");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + "...");  
        }
        System.out.println();
    }
}


public class PriorityQueue{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = sc.nextInt();

        PQueue queue = new PQueue(size);

        while (true){
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