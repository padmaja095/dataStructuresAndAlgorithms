package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConvertToFullBinaryTree {
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
        ConvertToFullBinaryTree tree = new ConvertToFullBinaryTree();
        tree.root = new Node(0);
        tree.root.left = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(4);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
        tree.root.left.left = new Node(3);
        tree.root.left.left.right = new Node(5);
        Node node = convertToFullBT(tree.root);
        levelOrderTraversal(node);
    }
    private static Node convertToFullBT(Node node) {
        if (node == null) {
            return node;
        }
        node.left = convertToFullBT(node.left);
        node.right = convertToFullBT(node.right);
        /*
         * if (node.left == null && node.right == null) {
         * return node;
         * }
         */
//        if (node.left != null && node.right != null) {
//            return node;
//        }
        if (node.left == null && node.right!=null) {
            return node.right;
        }
        if (node.right == null && node.left!=null) {
            return node.left;
        }
        return node;
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
