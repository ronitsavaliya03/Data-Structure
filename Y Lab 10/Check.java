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

    public boolean areSame(Node first1,Node first2){
        while (first1!=null && first2!=null) {
            if(first1.data!=first2.data){
                return false;
            }
            
            first1=first1.link;
            first2=first2.link;
        }

        return (first1==null && first2==null);
    }

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
}
public class Check {
    public static void main(String[] args) {
        LL list1=new LL();
        LL list2=new LL();

        list1.insert(5);
        list1.insert(6);
        list1.insert(8);
        list1.insert(7);
        list1.insert(11);

        list2.insert(5);
        list2.insert(6);
        list2.insert(8);
        list2.insert(7);
        list2.insert(4);

        System.out.println("List 1:");
        list1.printList();
        System.out.println("List 2:");
        list2.printList();

        System.out.println("---------------------------------------");
        System.out.println("Answer:");
        if(list1.areSame(list1.first, list2.first)){
            System.out.println("Lists are Same");
        }
        else{
            System.out.println("Lists are not Same");
        }

    }
}
