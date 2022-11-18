package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConstructSumTreeOfBT {
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
        ConstructSumTreeOfBT tree = new ConstructSumTreeOfBT();
        /*
         * 
         *  10
         * /   \
         -1    3
         / \    /
         4 5   -2
         * 
         * 
         */
        tree.root = new Node(10);
        tree.root.left = new Node(-1);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(-2);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        sumTree(tree.root);
        LevelOrderTraversal(tree.root);
       
    }
    private static void LevelOrderTraversal(Node root2) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root2);
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
    private static int sumTree(Node node) {
         if(node==null)
         {return 0;}
        if(node.left==null && node.right==null)
        {
            return node.data;
        }
        int vertex=node.data;
        node.data=sumTree(node.left)+sumTree(node.right);
        return node.data+vertex;
    } 
}
