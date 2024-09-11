import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value=value;
        left=right=null;
    }
}
class BinaryTree{
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null) {
            return false;
        }

        // Check if the current nodes have the same valueue and recursively check for left and right subtrees
        return (p.value == q.value) && 
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}

public class SametreeCheck {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 6, 8, 6, 5, 3};
        int[] arr2 = {8, 5, 5, 3, 6, 6, 3};

        BinaryTree bTree= new BinaryTree();

        TreeNode root1 = bTree.insertLevelOrder(arr1, 0);
        TreeNode root2 = bTree.insertLevelOrder(arr2, 0);  
        
        // Example usage: Level order traversal
        System.out.print("Level order Traversal of Tree1: ");
        bTree.levelOrderTraversal(root1);
        System.out.print("Level order Traversal of Tree2: ");
        bTree.levelOrderTraversal(root2);

        boolean result=bTree.isSameTree(root1, root2);

        if (result) {
            System.out.println("The trees are the same.");
        } else {
            System.out.println("The trees are not the same.");
        }


        

    }
}
