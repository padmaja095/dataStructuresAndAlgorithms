package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ChildSumPropertyOfBinaryTree {
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
        ChildSumPropertyOfBinaryTree tree = new ChildSumPropertyOfBinaryTree();
        /*
         * Construct the following binary tree
         * 20
         * / \
         * 12 8
         * / \ /\
         * 6 6 3 5
         * /
         * 5
         */
        tree.root = new Node(20);
        tree.root.left = new Node(12);
        tree.root.right = new Node(8);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(1);
        tree.root.right.right.right = new Node(5);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(6);
        // tree.hasChildSumProperty(tree.root);
        int val = tree.hasChildSumPropertyIterative(tree.root);
        if (val == 0) {
            System.out.println("Child sum Property doesnot exist ");
        } else {
            System.out.println("Child sum Property exist for the given tree ");

        }
    }
    private int hasChildSumPropertyIterative(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int l = 0, r = 0;
            if (curr.left != null) {
                queue.add(curr.left);
                l = curr.left.data;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                r = curr.right.data;
            }
            if (l + r != curr.data && (curr.right != null || curr.left != null)) {
                return 0;
            }
        }
        return 1;
    }
    private int hasChildSumProperty(Node node) {
        if ((node == null) || (node.right == null && node.left == null)) {
            return 1;
        }
        int l = 0, r = 0;
        if (node.right != null) {
            r = node.right.data;
        }
        if (node.left != null) {
            l = node.left.data;
        }
        /*
         * int left= hasChildSumProperty(node.left);
         * int right=hasChildSumProperty(node.right);
         */
        /*
         * if((l+r==node.data))
         * {
         * return 1;
         * }
         */
        if ((l + r == node.data) && hasChildSumProperty(node.left) == 1 &&
                hasChildSumProperty(node.right) == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
