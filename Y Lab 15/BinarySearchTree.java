class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinarySearchTree {
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public int findMin(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }

    public int findMax(TreeNode root) {
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = null;

        root = bst.insert(root, 50);
        root = bst.insert(root, 30);
        root = bst.insert(root, 20);
        root = bst.insert(root, 40);
        root = bst.insert(root, 70);
        root = bst.insert(root, 60);
        root = bst.insert(root, 80);

        int min = bst.findMin(root);
        System.out.println("Smallest element in the BST: " + min);

        int max = bst.findMax(root);
        System.out.println("Largest element in the BST: " + max);
    }
}
