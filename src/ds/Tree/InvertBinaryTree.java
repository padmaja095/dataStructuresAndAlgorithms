package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {
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
        InvertBinaryTree tree = new InvertBinaryTree();
        
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
       // levelOrderTraversal(tree.invertBT(tree.root));
        invertTreeUsinglevelOrder(tree.root);
        levelOrderTraversal(tree.root);
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
    private Node invertBT(Node node) {
        if(node==null)
        {
            return null;
        }
        Node left=invertBT(node.left);
        Node right=invertBT(node.right);
        node.left=right;
        node.right=left;
        return node;
    }
    private static void invertTreeUsinglevelOrder(Node node) {
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty())
        {
            Node curr=queue.poll();
            if(curr.left!=null)
            {
                queue.add(curr.left);
            }
            if(curr.right!=null)
            {
                queue.add(curr.right); 
            }
          //  if(curr.left!=null && curr.right!=null)
            //{
                Node temp=curr.left;
                curr.left=curr.right;
                curr.right=temp;
         //   }
            }

        }
    }

