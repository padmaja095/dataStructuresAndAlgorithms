package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintRightViewOfBT {
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
        PrintRightViewOfBT tree = new PrintRightViewOfBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(11);
        tree.root.right.right.right = new Node(12);
        tree.root.right.right.right.left = new Node(12);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printRightViewUsinglevelOrder(tree.root);
    }

    private void printRightViewUsinglevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    Node curr = queue.poll();
                    if (i == n - 1) {
                        System.out.println(curr.data);
                    }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                }
            }
        }
    }


