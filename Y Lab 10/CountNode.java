import java.util.*;
class Node{
    int data;
    Node link;

    public Node(int data){
        this.data=data;
        this.link=null;
    }
}
class CircularLL{
    Node first;
    public void insert(int data){
        Node newNode=new Node(data);
        Node temp=first;

        if(first==null){
            first=newNode;
            first.link=first;
            return;
        }

        while (temp.link!=first){
            temp=temp.link;
        }

        temp.link=newNode;
        newNode.link=first;
    }

    public void display(){
        Node temp=first;
        int count=0;

        do{
            System.out.print(temp.data+" --> ");
            temp=temp.link;
            count++;
        }while(temp!=first);

        System.out.println("(FirstNode) "+first.data+"...");
        System.out.println("\nTotal Number of Nodes in the LL: "+count);
    }
}

public class CountNode{
    public static void main(String[] args) {
        CircularLL list=new CircularLL();

        list.insert(1);
        list.insert(7);
        list.insert(3);
        list.insert(8);
        list.insert(5);
        list.insert(11);

        list.display();
        
    }  
}
