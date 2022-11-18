package ds.Tree;

public class MaxSumFromRootToLraf {
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
        MaxSumFromRootToLraf tree = new MaxSumFromRootToLraf();
        /*
         * Construct the following binary tree
         * 20
         * / \
         * 12 8
         * / \ /\
         * 6 6 3 1
         *  \     \
         *   1     5
         */
        tree.root = new Node(20);
        tree.root.left = new Node(12);
        tree.root.right = new Node(8);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(1);
        tree.root.right.right.right = new Node(5);
        tree.root.left.left = new Node(6);
        tree.root.left.left.right = new Node(1);
        tree.root.left.right = new Node(6);
        int max_sum=maxSum(tree.root);
        System.out.println(max_sum);

    }

    private static int maxSum(Node node) {
        if(node==null)
        {
            return 0;

        }
        if(node.left== null && node.right==null)
        {
            return node.data;
        }
        int l=maxSum(node.left);
        int r=maxSum(node.right);
        return Math.max(l, r)+node.data;
    }
}