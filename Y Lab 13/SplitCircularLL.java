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
    public void insert(int data){
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

    public void Split(){
        if(first==null || first.link==first){
            System.out.println("List is Empty or Have a single Node");
            return;
        }

        Node slow=first;
        Node fast=first;

        while(fast.link!=first && fast.link.link!=first){
            slow=slow.link;
            fast=fast.link.link;
        }

        if(fast.link.link == first){
            fast=fast.link;
        }

        Node first1= first;
        Node first2= slow.link;

        slow.link=first1;

        fast.link=first2;

        printList(first1);
        printList(first2);
    }

    public void printList(Node start) {
        if (start == null) {
            return;
        }
        Node temp = start;
        do {
            System.out.print(temp.data + " --> ");
            temp = temp.link;
        } while (temp != start);
        System.out.println("NULL");
    }
}
public class SplitCircularLL {
    public static void main(String[] args) {
        LL list=new LL();

        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
        list.insert(11);

        System.out.println("Circular List:");
        list.display();


        System.out.println("\nSplited Lists:");
        list.Split();


    }
}