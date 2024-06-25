package module4;

import com.sun.source.tree.Tree;

public class Tree1B<Key> {
    // array stores where the childen are, two links
    Key k;
    Tree1B[] children;

//    public void swim(int k) {
//        if (keys[parent(k)] > keys[k]) {
//            swap(k, parent(k));
//            swim(parent(k));
//        }
//    }

    private int parent(int k) {
        // iterative approach
//        int count = 0;
//        for (int i = 0; i <= k; i++) {
//            if (i == k) {
//                return count;
//            } else if (i % 2 == 0) {
//                count ++;
//            }
//        }
//        double result = (double) k / 2;
//        int roundedResult = (int) Math.ceil(result);
//        return roundedResult;

        return (k - 1) / 2;
    }

    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Depth First Search DFS
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    // Depth First Search DFS
    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Depth First Search DFS
    public void postorderTraversal(TreeNode root) {
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    // Breadth first search BFS
//    public void levelorderTraversal(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        genericQueue queue = new genericQueue<>();
//        queue.enQueue(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.deQueue();
//            System.out.print(node.data + " ");
//
//            if (node.left != null) {
//                queue.enQueue(node.left);
//            }
//
//            if (node.right != null) {
//                queue.enQueue(node.right);
//            }
//
//
//        }
//    }
}
