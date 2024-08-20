import java.util.ArrayList;

class Node{
    int data;
    Node lptr;
    Node rptr;
    
    Node(int value){
        this.data=value;
    }

}
class Implement{
    // Node root=null;
    public Node insert(Node root, int value){
        if(root==null){
            root=new Node(value);
            return root;
        }

        if(root.data>value){
            root.lptr=insert(root.lptr, value);
        }
        else if(root.data<value){
            root.rptr=insert(root.rptr, value);
        }
        return root;
    }

    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.lptr);
        System.out.print(root.data+" ");
        inorder(root.rptr);
    }

    public boolean search(Node root,int key){
        if(root==null){
            return false;
        }

        if(root.data>key){
            return search(root.lptr, key);
        }
        else if(root.data==key){
            return true;
        }
        else{
            return search(root.rptr, key);
        }
    }

    public Node delete(Node root,int value){
        if(root.data>value){
            root.lptr=delete(root.lptr, value);
        }
        else if(root.data<value){
            root.rptr=delete(root.rptr, value);
        }
        else{
            if(root.lptr==null && root.rptr==null){
                return null;
            }
            
            if(root.lptr==null){
                return root.rptr;
            }
            else if(root.rptr==null){
                return root.lptr;
            }

            Node Is=inorderSuccessor(root.rptr);
            root.data=Is.data;
            delete(root.rptr, Is.data);
        }

        return root;
    }

    public void printInRange(Node root,int x,int y){
        if(root==null){
            return;
        }

        if(root.data>=x && root.data<=y){
            printInRange(root.lptr, x, y);
            System.out.print(root.data+" ");
            printInRange(root.rptr, x, y);
        }
        else if(root.data>=y){
            printInRange(root.lptr, x, y);
        }
        else{
            printInRange(root.rptr, x, y);
        }
    }

    public void printRoot2Leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.data);
        if(root.lptr==null && root.rptr==null){
            printPath(path);
        }else{
            printRoot2Leaf(root.lptr, path);
            printRoot2Leaf(root.rptr, path);
        }
        path.remove(path.size()-1);
    }


    //Helper Function
    public Node inorderSuccessor(Node root){
        while (root.lptr!=null){
            root=root.lptr;
        }
        return root;
    }

    public void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+" --> ");
        }
        System.out.print("NULL");
        System.out.println();
    }
}
public class BST {
    public static void main(String[] args) {
        int []values={8, 5, 3, 1, 4, 6, 10, 11, 14};

        Implement bst=new Implement();

        Node root=null;
        for(int i=0; i<values.length; i++){
            root=bst.insert(root,values[i]);
        }

        System.out.print("Inorder: ");
        bst.inorder(root);
        System.out.println();

        int key=11;

        if(bst.search(root, key)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }

        System.out.print("After Delete Node: ");
        bst.delete(root, key);


        System.out.print("Inorder: ");
        bst.inorder(root);
        System.out.println();

        System.out.print("Range between two numbers: ");
        bst.printInRange(root, 3, 11);
        System.out.println();

        System.out.println("Paths:");
        bst.printRoot2Leaf(root, new ArrayList<>());
    }
}
