class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}
class LL{
        Node first;
      
        public void reverseIterate(){
        
          if(first==null || first.link==null){
              return;
          }
        
          Node prevNode=first;
          Node currNode=first.link;
        
          while (currNode!=null) {
              Node linkNode=currNode.link;
              currNode.link=prevNode;
          
              //update
              prevNode=currNode;
              currNode=linkNode;
          }
          first.link=null;
          first=prevNode;
      }
      
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

}
public class ReverseLL {
  public static void main(String[] args) {
    LL list = new LL();

    list.insert(5);
    list.insert(5);
    list.insert(7);
    list.insert(4);
    list.insert(9);
    list.insert(3);
    list.insert(7);
    list.insert(2);

    list.display();
    list.reverseIterate();
    list.display();

  }  
}
