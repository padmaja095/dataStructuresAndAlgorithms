package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PathSum {
    // given tree and sum. check if the sum exists frm root to any leaf node.
    // using linkedlist
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public static void main(String args[]) {
        PathSum tree = new PathSum();

        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(8);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(1);
        tree.root.right.left = new Node(13);
        tree.root.left.left = new Node(11);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(2);
        levelOrderTraversal(tree.root);
        boolean bool = findPathSum(tree.root, 22, 0);
        System.out.println(bool);
    }

    private static boolean findPathSum(Node node, int sum, int val) {
        if (node == null) {
            return false;
        }
        val = val + node.data;
        if (isLeaf(node) && val == sum) {
            return true;
        }
        return findPathSum(node.left, sum, val) || findPathSum(node.right, sum, val);
        //both above return statement and below commented one works the same.
        /*
         * if(findPathSum(node.left, sum, val) || findPathSum(node.right, sum, val))
         * {
         * return true;
         * }
         */
    }

    private static boolean isLeaf(Node node) {
        if (node.left == null && node.right == null) 
            return true;
        return false;
    }
    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
}
