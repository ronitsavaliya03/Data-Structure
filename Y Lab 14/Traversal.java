class Node{
    int data;
    Node lptr;
    Node rptr;
    
    Node(int value){
        this.data=value;
    }

}
class ImplementTree{
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

    public void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        inorder(root.lptr);
        inorder(root.rptr);
    }

    public void postorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.lptr);
        inorder(root.rptr);
        System.out.print(root.data+" ");
    }
}
public class Traversal {
    public static void main(String[] args) {
        int []values={8, 7, 9, 5, 3, 6, 1, 4};

        ImplementTree bst=new ImplementTree();

        Node root=null;
        for(int i=0; i<values.length; i++){
            root=bst.insert(root,values[i]);
        }

        System.out.print("Inorder: ");
        bst.inorder(root);
        System.out.println();
    
        System.out.print("Preorder: ");
        bst.preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        bst.postorder(root);
        System.out.println();
    }
}
