package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumofAllLeftNodes {
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
        SumofAllLeftNodes tree = new SumofAllLeftNodes();
        /*
         * Construct the following binary tree
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 8
         * / \
         * 7 9
         */
        tree.root = new Node(10);
        tree.root.left = new Node(7);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(30);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(8);
        System.out.println(tree.sumofAllLeftNodes(tree.root));
       // System.out.println(tree.count);
    }
   
    private int sumofAllLeftNodes(Node node) {
        int count=0;
        if(node==null)
            return 0;
        count=count+1+sumofAllLeftNodes(node.left);
        sumofAllLeftNodes(node.right);
        return count;
        }
        /*
         * sumofAllLeftNodes(node.right);
         * return 1+sumofAllLeftNodes(node.left);
         */
       
    
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
