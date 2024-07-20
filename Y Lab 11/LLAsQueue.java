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

    public void add(int data){
        Node newNode=new Node(data);

        if(first==null){
            first=newNode;
            return;
        }

        Node temp=first;
        while (temp.link!=null){
            temp=temp.link;
        }

        temp.link=newNode;
    }

    public void remove(){   
        if(first==null){
            System.out.print("Stack is Empty.!");
            return;
        }
        first=first.link;
    }

    public void display(){
        if(first==null){
            System.out.println("Queue is Empty.!");
            return;
        }
        Node temp=first;
        while (temp!=null){
            System.out.print(temp.data+"...");
            temp=temp.link;
        }
        System.out.println("NULL");
    }
}
public class LLAsQueue {
    public static void main(String[] args) {
        LL queue=new LL();

        queue.add(6);
        queue.add(5);
        queue.add(4);
        queue.add(15);
        queue.add(11);
        queue.add(63);

        queue.display();

        queue.add(88);
        queue.display();

        queue.remove();
        queue.remove();
        queue.display();

    }
    
}
