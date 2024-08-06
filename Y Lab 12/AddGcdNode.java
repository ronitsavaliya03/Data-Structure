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

      public void addGcdNode(){
        AddGcdNode object=new AddGcdNode();

        Node save=first;
        Node next=save.link;

        while (save!=null && save.link!=null) {
            next=save.link;
            int value=object.findGCD(save.data, next.data);

            Node gcdNode=new Node(value);

            gcdNode.link=next;
            save.link=gcdNode;
            save=gcdNode.link;
        }
      }

}
public class AddGcdNode {
    public int findGCD(int a,int b){
        if(b==0){
            return a;
        }else if(b>a){
            return findGCD(b,a);
        }else{
            return findGCD(b, a%b);
        }
    }
    public static void main(String[] args) {
        LL list=new LL();

        list.insert(18);
        list.insert(6);
        list.insert(10);
        list.insert(3);

        list.display();

        list.addGcdNode();

        list.display();



    }
    
}