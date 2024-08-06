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
    public void insert(int data) {
        Node newNode = new Node(data);
        if(first==null){
            first=newNode;
            return; 
        }
      
        Node save=first;
        while (save.link!=null) {
            save=save.link;
        }
        save.link=newNode;
      }
      
      public void display() { 
        if (first == null) {
            System.out.println("List is Empty.!");
            return;
        }
      
        Node save = first;
        while (save != null) {
            System.out.print(save.data + " --> ");
            save = save.link;
        }
        System.out.println("NULL");
      }

      public void swapNode(){
        if (first == null || first.link == null) {
            return;
        }
        
        Node dummy=new Node(0);
        dummy.link=first;
        Node pred=dummy;
        Node save=first;
        Node next=first.link;        
 
        while(save!=null && save.link!=null){

            next=save.link;

            pred.link=next;
            save.link=next.link;
            next.link=save;

            pred=save;
            save=save.link;

        }
        first=dummy.link;
        
      }

}
public class SwapConsecutive {
    public static void main(String[] args) {
        LL list=new LL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.display();
        list.swapNode();
        list.display();  

    }
}
