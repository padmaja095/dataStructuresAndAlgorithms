package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class SpiralOrderOfBinaryTree {
    // 2 approaches: using 1 queue and 1 stack
    // using 2 stacks
    // using linkedlist
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 7, 5, 12, 3, 4, 6, 8, 16, 1, 10, 0, 2 };
        int n = arr.length;
        Node root = constructBST(arr, n);
        // System.out.println(root.data);
        // inOrdertraversal(root);
        // Level order traversal need queue
         SpiralOrderTraversalApproach1(root);
         System.out.println();
        SpiralOrderTraversalApproach2(root);
    }

    private static void SpiralOrderTraversalApproach2(Node root) {
        Stack<Node> stackOdd = new Stack<Node>();
        Stack<Node> stackEven = new Stack<Node>();
        stackOdd.push(root);
        // stackodd pushes from right to left
        // stackeven pushes from left to right
        while (!stackOdd.isEmpty() || !stackEven.isEmpty()) {
            while (!stackOdd.isEmpty()) {
                Node curr = stackOdd.pop();
                System.out.print(curr.data + " ");
                if (curr.right != null) {
                    stackEven.push(curr.right);
                }
                if (curr.left != null) {
                    stackEven.push(curr.left);
                }
            }
            while (!stackEven.isEmpty()) {
                Node curr = stackEven.pop();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    stackOdd.push(curr.left);
                }
                if (curr.right != null) {
                    stackOdd.push(curr.right);
                }
            }
        }
    }

    private static void SpiralOrderTraversalApproach1(Node root) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth = depth + 1;
            while (size > 0) {
                Node curr = queue.poll();
                --size;
                if (curr.left != null) {
                    queue.add(curr.left);
                    if (depth > 1 && depth % 2 == 0) {
                        stack.push(curr.left);
                    }
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    if (depth > 1 && depth % 2 == 0) {
                        stack.push(curr.right);
                    }
                }
                if (depth > 1 && depth % 2 != 0 && !stack.isEmpty()) {
                    System.out.print(stack.pop().data + " ");
                } else {
                    System.out.print(curr.data + " ");

                }
            }

        }
    }
    private static void inOrdertraversal(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.println(root.data);
            inOrdertraversal(root.left);
            inOrdertraversal(root.right);
        }
    }

    private static Node constructBST(int[] arr, int n) {
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = treeComparisonRecursion(root, arr[i]);
        }
        return root;
    }

    private static Node treeComparisonRecursion(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.data) {
            root.left = treeComparisonRecursion(root.left, data);
        } else {
            root.right = treeComparisonRecursion(root.right, data);
        }
        return root;
    }

    static Node getNode(int data) {
        Node newNode = new Node(data);
        newNode.left = newNode.right = null;
        return newNode;
    }
}
