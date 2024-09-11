import java.util.Queue;
import java.util.LinkedList;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value=value;
        left=right=null;
    }
}

public class SymmetricTree {

    public TreeNode insertLevelOrder(int[] array, int i) {
        TreeNode root = null;
        if (i < array.length) {
            root = new TreeNode(array[i]);
            root.left = insertLevelOrder(array, 2 * i + 1);
            root.right = insertLevelOrder(array, 2 * i + 2);
        }
        return root;
    }

    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

        System.out.println();
    }


    public boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1.left==null && root2.right==null){
            return true;
        }

        if(root1.left==null || root2.right==null){
            return false;
        }

        return (root1.left.value==root2.right.value) &&
        isSymmetric(root1.left, root2.right) &&
        isSymmetric(root1.right, root2.left);
    }


    public static void main(String[] args) {
        int[] arr = {8, 5, 5, 3, 6, 6, 3};

        SymmetricTree bTree= new SymmetricTree();

        TreeNode root = bTree.insertLevelOrder(arr, 0);  

        boolean result=bTree.isSymmetric(root.left, root.right);

        if (result) {
            System.out.println("The tree is Symmetric");
        } else {
            System.out.println("The tree is not Symmetric");
        }
    }
}
