import java.util.*;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {
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
            System.out.print(tempNode.val + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

        System.out.println();
    }

    
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    public int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;  // A null tree has height 0
        }
        
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;  // Left subtree is not balanced
        }
        
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;  // Right subtree is not balanced
        }
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class BalancedBinaryTree {
    public static void main(String[] args) {
        int[] arr = {8, 5, 5, 3, 6, 6, 3};

        Solution tree=new Solution();
        TreeNode root=tree.insertLevelOrder(arr, 0);

        boolean result=tree.isBalanced(root);

        if (result) {
            System.out.println("The tree is Balanced");
        } else {
            System.out.println("The tree is not Balanced");
        }

    }
}
