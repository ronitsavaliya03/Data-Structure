class Node{
    int data;
    Node lptr;
    Node rptr;

    Node(int data){
        this.data=data;
        this.lptr=null;
        this.rptr=null;
    }
}
class LL{
    Node first;
    Node last;

    LL(){
        this.first=null;
        this.last=null;
    }

    public void insert(int data){
        Node newNode=new Node(data);

        if(first==null){
            first=newNode;
            last=newNode;
        }else{
            newNode.lptr=last;
            last.rptr=newNode;
            last=newNode;
        }
    }

    public void display() {
        if (first == null) {
            System.out.println("List is Empty.!");
            return;
        }

        Node save = first;

        System.out.print("NULL <--> ");
        while (save != null) {
            System.out.print(save.data + " <--> ");
            save = save.rptr;
        }
        System.out.println("NULL");
    }

    public void DeleteAlternate(){
        if(first==null){
            System.out.println("List is empty.!");
            return;
        }

        Node save=first;
        Node delete=save.rptr;

        while(save.rptr!=null && save!=null && delete.rptr!=null){

            save.rptr=delete.rptr;

            // if(delete.rptr!=null){
            delete.rptr.lptr=save;
            // }

            delete.rptr=null;
            delete.lptr=null;

            save=save.rptr;

            delete=save.rptr;
        }

        if(delete!=null && delete.rptr==null){
            save.rptr=null;
        }
    }
}
public class DeleteAlternateNode {
    public static void main(String[] args) {
        LL list=new LL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);

        list.display();

        list.DeleteAlternate();
        list.display();

    }
}
