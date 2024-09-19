import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.data=value;
        left=right=null;
    }
}
public class ConstructBTreeFromTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes");
        int n = sc.nextInt();  // Read the number of nodes

        int[] pre = new int[n];
        int[] post = new int[n];

        System.out.println("Enter Preorder Traversal");
        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }

        System.out.println("Enter Postorder Traversal");
        for (int i = 0; i < n; i++) {
            post[i] = sc.nextInt();
        }

        ConstructBTree cb = new ConstructBTree();
        TreeNode root = cb.constructFromPrePost(pre, post);

        BSTTree btree = new BSTTree();
        btree.inorder(root);

        sc.close();
    }
}

class ConstructBTree {
    int preIndex;
    int posIndex;

    public ConstructBTree() {
        preIndex = 0;
        posIndex = 0;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        
        if (root.data != post[posIndex])
            root.left = constructFromPrePost(pre, post);
        
        if (root.data != post[posIndex])
            root.right = constructFromPrePost(pre, post);
        
        posIndex++;
        
        return root;
    }
}

class BSTTree{
    public TreeNode insert(TreeNode root, int value){
        if(root==null){
            root=new TreeNode(value);
            return root;
        }

        if(root.data>value){
            root.left=insert(root.left, value);
        }
        else if(root.data<value){
            root.right=insert(root.right, value);
        }
        return root;
    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        inorder(root.left);
        inorder(root.right);
    }

    public void postorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data+" ");
    }
}