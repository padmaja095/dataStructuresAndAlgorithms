package ds.Tree;

public class MergeTwoBinaryTrees {
     // using linkedlist
     static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root1;
    Node root2;

    public static void main(String args[]) {
        MergeTwoBinaryTrees tree = new MergeTwoBinaryTrees();
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
        tree.root1 = new Node(1);
        tree.root1.left = new Node(3);
        tree.root1.right = new Node(2);
        tree.root1.left.left = new Node(5);
        tree.root1.left.left.left = new Node(6);

        tree.root2 = new Node(2);
        tree.root2.left = new Node(1);
        tree.root2.right = new Node(3);
        tree.root2.left.right = new Node(4);
        tree.root2.right.right = new Node(7);
       Node outputNode= tree.mergeTwoBinaryTrees(tree.root1,tree.root2);
       inOrdertraversal(outputNode);
       
        
    }
    private static void inOrdertraversal(Node root) {
        if(root==null)
        {
            return;
        }
        else{
            System.out.println(root.data);
            inOrdertraversal(root.left);
            inOrdertraversal(root.right);
        }
    }

    private Node mergeTwoBinaryTrees(Node t1, Node t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.data += t2.data;
        t1.left = mergeTwoBinaryTrees(t1.left, t2.left);
        t1.right = mergeTwoBinaryTrees(t1.right, t2.right);
        return t1;

    }
       
}
