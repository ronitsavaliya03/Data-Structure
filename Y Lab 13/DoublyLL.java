import java.util.*;
class Node{
    int data;
    Node lptr;
    Node rptr;

    Node(int data){
        this.data=data;
        this.lptr=null;
        this.rptr=null;
    }
}
class LL{
    Node first;
    Node last;

    LL(){
        this.first=null;
        this.last=null;
    }

    public void insertAtFirst(int data){
        Node newNode=new Node(data);

        if(first==null){
            first=newNode;
            last=newNode;
        }else{
            newNode.rptr=first;
            first.lptr=newNode;
            first=newNode;
        }
    }

    public void insertAtLast(int data){
        Node newNode=new Node(data);

        if(first==null){
            first=newNode;
            last=newNode;
        }else{
            newNode.lptr=last;
            last.rptr=newNode;
            last=newNode;
        }

    }

    public void delete(int data){
        if(first==null){
            System.out.println("Underflow");
            return;
        }

        if(first==last){
            first=null;
            last=null;
        }else if(data==first.data){
            first=first.rptr;
            first.lptr=null;
            return;
        }

        Node save=first;
        Node prev=null;

        while (save!=null && save.data!=data) {
            prev=save;
            save=save.rptr;
        }
        prev=prev.rptr;
        
        if(save==null){
            System.out.println("Node not Found");
            return;
        }
                
        if(data==last.data){
            last=last.lptr;
            last.rptr=null;
        }else{
            prev.lptr.rptr=prev.rptr;
            prev.rptr.lptr=prev.lptr;
        }
    }

    public void display() {
        if (first == null) {
            System.out.println("List is Empty.!");
            return;
        }

        Node save = first;

        System.out.print("NULL <--> ");
        while (save != null) {
            System.out.print(save.data + " <--> ");
            save = save.rptr;
        }
        System.out.println("NULL");
    }

}
public class DoublyLL{
    public static void main(String[] args) {
        LL list =new LL();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\nList Operations Menu:");
            System.out.println("1. Insert a node at the front of the linked list.");
            System.out.println("2. Delete a node from specified position.");
            System.out.println("3. Insert a node at the end of the linked list.");
            System.out.println("4. Display all nodes.");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter the element you want to add first: ");
                    int element = sc.nextInt();
                    list.insertAtFirst(element);
                    list.display();
                    break;
                case 2:
                    System.out.print("Enter the element you want to delete: ");
                    element = sc.nextInt();
                    list.delete(element);
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter the element you want to add last: ");
                    element = sc.nextInt();
                    list.insertAtLast(element);
                    list.display();
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(1);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    }
    
}


