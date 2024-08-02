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

      public void deleteDuplicate(){
        if(first==null){
            System.out.println("List is empty.!");
            return;
        }

        // Node save= first;
        // while(save!=null && save.link!=null){
        //     if(save.data==save.link.data){
        //         save.link=save.link.link;
        //     }else{
        //         save=save.link;
        //     }
        // }

        Node save = first;
        Node next = save.link;
        Node prev = save;
        
        while (save != null) {
            next=save.link;
            prev=save;
            while (next != null) {
                if(save.data==next.data){
                    prev.link=next.link;
                }else{
                    prev = prev.link;
                }
                
                next = next.link;
            }
            save = save.link;
        }
      }
}
public class DeleteDuplicateNode {
    public static void main(String[] args) {
        LL list= new LL();

        list.insert(1);
        list.insert(3);
        list.insert(1);
        list.insert(2);
        list.insert(1);
        list.insert(2);
        list.insert(5);
        list.insert(5);
        list.insert(4);

        list.insert(1);
        list.insert(6);
        list.insert(6);

        list.display();
        list.deleteDuplicate();
        list.display();
    }
}
