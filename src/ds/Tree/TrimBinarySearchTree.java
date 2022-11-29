package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TrimBinarySearchTree {
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
        TrimBinarySearchTree tree = new TrimBinarySearchTree();
        /*
         * Construct the following binary tree
         * 10
         * / \
         * 7  20
         * / \ / \
         * 4 8 15 30
         *  
         * 
         */
        tree.root = new Node(10);
        tree.root.left = new Node(7);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(30);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(8);
        levelOrderTraversal(tree.trimBST(tree.root, 7, 15));
    }
    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node curr=queue.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null)
            {
                queue.add(curr.left);
            }
            if(curr.right!=null)
            {
                queue.add(curr.right); 
            }
        }
    }
    private Node trimBST(Node node, int l, int r) {
        if (node == null) 
            return null;
        if (node.data < l) 
            return trimBST(node.right, l, r);
        if (node.data > r) 
            return trimBST(node.left, l, r);
        node.left = trimBST(node.left, l, r);
        node.right = trimBST(node.right, l, r);
        return node;
    }
}
