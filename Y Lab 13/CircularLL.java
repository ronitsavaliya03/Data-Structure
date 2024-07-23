import java.util.*;
class Node{
    int data;
    Node link;

    Node(int data){
        this.data=data;
        this.link=null;
    }
}
class LL{
    Node first;
    Node last;
    public void insertAtFirst(int data){
        Node newNode=new Node(data);
        if(first==null){
            newNode.link=newNode;
            first=newNode;
            last=newNode;
        }else{
            newNode.link=first;
            last.link=newNode;
            first=newNode;
        }
    }

    public void insertAtLast(int data){
        Node newNode=new Node(data);
        if(first==null){
            newNode.link=newNode;
            first=newNode;
            last=newNode;
        }else{
            newNode.link=first;
            last.link=newNode;
            last=newNode;
        }
    }

    public void delete(int data){
        if(first==null){
            System.out.println("LinkedList is Empty.!");
            return;
        }
        Node save=first;
        Node pred=null;

        while(save.data!=data && save!=last){
            pred=save;
            save=save.link;
        }

        if(save.data!=data){
            System.out.println("Node not Found");
            return;
        }

        if(first==last){
            first=null;
            last=null;
        }else if(data==first.data){
            first=first.link;
            last.link=first;
        }else{
            pred.link=save.link;
            if(data==last.data){
                last=pred;
            }
        }
    }

    public void display(){
        Node temp=first;
        if(first==null){
            System.out.println("LinkedList is empty.!");
            return;
        }
        //int count=0;

        do{
            System.out.print(temp.data+" --> ");
            temp=temp.link;
            //count++;
        }while(temp!=first);

        System.out.println("(FirstNode) "+first.data+"...");
    }
}
public class CircularLL {
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
