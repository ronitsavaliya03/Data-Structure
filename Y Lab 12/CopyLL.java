class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}
class Copy{
    Node first;
    public void insert(int data) {
        Node newNode = new Node(data);
        if(first==null){
            first=newNode;
            return; 
        }

        Node currNode=first;
        while (currNode.link!=null) {
            currNode=currNode.link;
        }
        currNode.link=newNode;
    }

    public void display() {
        if (first == null) {
            System.out.println("List is Empty.!");
            return;
        }


        Node currNode = first;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.link;
        }
        System.out.println("NULL");
    }

    public void copy(Copy list){
        if(first==null){
            System.out.println("List is empty.!");
            return;
        }

        Node save=first;
        while(save!=null){
            list.insert(save.data);
            save=save.link;
        }
    }
}
public class CopyLL {
    public static void main(String[] args){
        Copy list1=new Copy();
        Copy list2=new Copy();


        list1.insert(5);
        list1.insert(6);
        list1.insert(8);
        list1.insert(4);
        list1.insert(9);
        list1.insert(8);
        list1.insert(7);

        list1.display();

        list1.copy(list2);

        list2.display();
        
    }
    
}
