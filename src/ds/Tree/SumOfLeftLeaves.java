package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumOfLeftLeaves {
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
        SumOfLeftLeaves tree = new SumOfLeftLeaves();
        /*
         * Construct the following binary tree
         * 3
         * / \
         * 9 20
         * /  /
         * 15 7
         */
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);
        System.out.println(tree.SumOfLeftLeaves(tree.root));
    }
    int sum = 0;
    private int SumOfLeftLeaves(Node node) {
        if (node == null) {
            return sum;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum = sum + node.left.data;
        }
        SumOfLeftLeaves(node.left);
        SumOfLeftLeaves(node.right);
        return sum;
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
