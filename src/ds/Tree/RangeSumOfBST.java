package ds.Tree;

import javax.lang.model.util.ElementScanner14;

public class RangeSumOfBST {
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
        RangeSumOfBST tree = new RangeSumOfBST();
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
        System.out.println( tree.rangeSum(tree.root,7,15));
    }
    private int rangeSum(Node node, int l, int r) {
        if(node==null)
        {
            return 0;
        }
        if(node.data>=l && node.data<=r)
        {
           return  node.data+rangeSum(node.left, l, r)+rangeSum(node.right, l, r);
                }        
       else if(node.data<l)
         {
             return rangeSum(node.right, l, r);
         }
        else{
             return rangeSum(node.left, l, r);
         }
    }

    
}
