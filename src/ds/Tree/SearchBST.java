package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SearchBST {
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
        SearchBST tree = new SearchBST();
       
        tree.root = new Node(10);
        tree.root.left = new Node(7);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(30);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(8);
        levelOrderTraversal(tree.searchBSTRecursive(tree.root,20));
    }
    private Node searchBSTRecursive(Node node, int val) {
        if(node==null)
            return null;
        if(node.data>val)
            return searchBSTRecursive(node.left, val);
        if(node.data<val)
            return searchBSTRecursive(node.right, val);
        return node;
    }
    private Node searchBSTIterative(Node node,int val)
    {
        while (node != null && node.data != val) {
            node = val < node.data ? node.left : node.right;
        }
        return node;
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
}
