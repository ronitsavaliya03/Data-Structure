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

    public void push(int data){
        Node newNode=new Node(data);
        if(first==null){
            first=newNode;
            return;
        }

        newNode.link=first;
        first=newNode;
    }

    public void pop(){
        if(first==null){
            System.out.print("Stack is Empty.!");
            return;
        }
        first=first.link;
    }

    public void display(){
        if(first==null){
            System.out.println("Stack is Empty.!");
            return;
        }

        Node temp=first;
        while (temp!=null){
            System.out.println("|  "+temp.data+"  |");
            temp=temp.link;
        }
        System.out.println("|______|");
    }
}
public class LLAsStack {
    public static void main(String[] args) {
        LL stack=new LL();

        stack.push(21);
        stack.push(14);
        stack.push(53);
        stack.push(85);
        stack.push(38);
        stack.push(62);

        stack.display();

        stack.pop();
        stack.pop();

        System.out.println("\nAfter popped: \n");
        stack.display();
    }
    
}
