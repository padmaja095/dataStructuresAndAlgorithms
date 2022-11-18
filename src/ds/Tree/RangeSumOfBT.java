package ds.Tree;

public class RangeSumOfBT {
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
        RangeSumOfBT tree = new RangeSumOfBT();
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
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(11);
        tree.root.right.right.right = new Node(12);
        tree.root.right.right.right.left = new Node(12);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println( tree.rangeSum(tree.root,7,15));
    }
    int sum=0;
    private int rangeSum(Node node, int l, int r) {
        if(node==null)
        {
            return 0;
        }
        if(node.data>=l && node.data<=r)
        {
            sum=sum+node.data;
        }
       rangeSum(node.left, l, r);
       rangeSum(node.right, l, r);
        return sum;
    }

}
