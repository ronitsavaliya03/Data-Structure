import java.util.Scanner;

class Node{
    int data;
    Node link;

    Node(int data){
        this.data=data;
        this.link=null;
    }
}
class Swap{
    Node first;
    public void insert(int data) {
        Node newNode = new Node(data);
        if(first==null){
            first=newNode;
            return; 
        }

        Node save=first;
        while (save.link!=null) {
            save=save.link;
        }
        save.link=newNode;

    }

    public void display() {
        if (first == null) {
            System.out.println("List is Empty.!");
            return;
        }

        Node save = first;
        while (save != null) {
            System.out.print(save.data + " --> ");
            save = save.link;
        }
        System.out.println("NULL");
    }

    public void swapNode(int k){
        if(first==null){
            System.out.println("Empty");
            return;
        }

        if(k<0){
            System.out.println("Invalid value of k try again.!");
            return;
        }

        Node save=first;
        int length=0;

        while (save!=null){
            save=save.link;
            length++;
        }

        if(k>length){
            System.out.println("Out of Bound");
            return;
        }

        Node start=first;
        for(int i=1; i<k; i++){
            start=start.link;
        }

        Node end=first;
        for(int i=length-k; i>0; i--){
            end=end.link;
        }

        int temp=start.data;
        start.data=end.data;
        end.data=temp;

    }

}
public class SwapKthNode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Swap list=new Swap();

        while (true){
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at the front of the linked list.");
            System.out.println("2. Display all nodes.");
            System.out.println("3. Swap the element.");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();

            switch (choice) {
                case 1: System.out.print("Enter the Value of Node:");
                        int value=sc.nextInt();
                        list.insert(value);
                        list.display();
                        break;

                case 2: list.display();
                        break;

                case 3: System.out.print("Enter Kth Node: ");
                        value=sc.nextInt();
                        list.swapNode(value);
                        list.display();
                        break;
                
                case 4: System.out.println("Exiting...");
                        return;

                default: System.out.println("Invalid Choice.!");
                         break;
            }
            
        }
    }
    
}
