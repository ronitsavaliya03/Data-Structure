import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return; 
        }

        Node currNode=head;
        while (currNode.next!=null) {
            currNode=currNode.next;
        }
        currNode.next=newNode;

    }

    public void printList() {
        if (head == null) {
            System.out.println("List is Empty.!");
            return;
        }

        System.out.println("_______________________");

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void insord(int data){
        Node newNode=new Node(data);

        if(head==null){
            head = newNode;
            return;
        }

        if(newNode.data<=head.data){
            newNode.next=head;
            return;
        }

        Node currNode=head;
        while (currNode.next!=null && data>=currNode.next.data){
            currNode=currNode.next;
        }

        newNode.next=currNode.next;
        currNode.next=newNode;

    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("LinkedList is Empty.");
            return;
        }

        head=head.next;

    }

    public void deleteLast(){
        if(head==null){
            System.out.println("LinkList is Empty.");
            return;
        }

        if(head.next==null){
            head=null;
            return;
        }

        Node secondLast=head;
        Node lastNode=head.next;
    
        while (lastNode.next!=null){
            lastNode=lastNode.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
    }

    public void delete(int data){
        if(head==null){
            System.out.println("List is Empty.!");
            return;
        }

        Node currNode=head;
        Node prev=null;

        if(currNode.data==data){
            head=currNode.next;
            return;
        }

        while (currNode!=null && currNode.data!=data) {
            prev=currNode;
            currNode=currNode.next;
        }

        if(currNode==null){
            System.out.println("Node not Found");
            return;
        }

        prev.next=currNode.next;
    }

    public void getSize(){
        if(head==null){
            System.out.println("List is Empty.!");
            return;
        }
        Node currNode=head;
        int count=1;
        while (currNode.next!=null) {
            currNode=currNode.next;
            count++;
        }
        System.out.println(count);
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true){
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at the front of the linked list.");
            System.out.println("2. Delete a first node of the linked list.");
            System.out.println("3. Insert a node at the end of the linked list.");
            System.out.println("4. Delete a last node of the linked list.");
            System.out.println("5. Delete a node from specified position.");
            System.out.println("6. Insert a node Ascending Order.");
            System.out.println("7. Display all nodes.");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();

            switch (choice) {
                case 1: System.out.print("Enter the Value of Node:");
                        int value=sc.nextInt();
                        list.addFirst(value);
                        break;

                
                case 2: list.deleteFirst();
                        break;

                case 3: System.out.print("Enter the Value of Node:");
                        value=sc.nextInt();
                        break;

                case 4: list.deleteLast();
                        break;

                case 5: System.out.print("Enter the Value you want to delate:");
                        value=sc.nextInt();
                        list.delete(value);
                        break;

                case 6: System.out.println("Enter the Value of Node:");
                        value=sc.nextInt();
                        list.insord(value);
                        break;

                case 7: list.printList();
                        break;

                case 8: System.out.println("Exiting...");
                        return;

                default: System.out.println("Invalid Choice.!");
                        break;
            }
           
        }
       
    }
}
