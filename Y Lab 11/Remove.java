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

    public void insert(int data){
        Node newNode=new Node(data);

        newNode.link=first;
        first=newNode;

    }

    public void printList() {
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

    public void deleteDuplicate(){
        Node temp=first;

        while(temp!=null){

            Node check=temp;
            while(check.link!=null){

                if(check.link.data==temp.data){
                    check.link=check.link.link;
                }
                else{
                    check=check.link;
                }

            }
            
            temp=temp.link;
        }
    } 
}
public class Remove{
    public static void main(String[] args) {
        LL list=new LL();

        list.insert(5);
        list.insert(77);
        list.insert(8);
        list.insert(53);
        list.insert(8);
        list.insert(39);
        list.insert(8);
        list.insert(5);

        list.printList();
        list.deleteDuplicate();
        list.printList();

    }
    
}
