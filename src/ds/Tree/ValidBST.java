package ds.Tree;
public class ValidBST {
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
        ValidBST tree = new ValidBST();
        /*
         * Construct the following binary tree
         *  5
         * /  \
         * 1    7
         *  \  / \
         *   4 6 30
         *  
         * 
         */
        tree.root = new Node(5);
        tree.root.left = new Node(1);
        tree.root.right = new Node(9);
        tree.root.right.left = new Node(8);
        tree.root.right.left.left = new Node(6);
        tree.root.right.left.left = new Node(7);
        tree.root.right.right = new Node(30);
       // tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(4);
        System.out.println(tree.isValidBST(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    private boolean isValidBST(Node node, int minValue, int maxValue) {
        if(node==null)
        {return true;}
        if(node.data<=minValue || node.data >=maxValue)
        {return false;}
        return isValidBST(node.left, minValue, node.data) && isValidBST(node.right, node.data, maxValue);
    }
    
}
