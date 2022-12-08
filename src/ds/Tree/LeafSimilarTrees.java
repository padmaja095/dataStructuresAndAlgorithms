package ds.Tree;
import java.util.ArrayList;
public class LeafSimilarTrees {
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
        LeafSimilarTrees tree1 = new LeafSimilarTrees();
        LeafSimilarTrees tree2 = new LeafSimilarTrees();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.right.right = new Node(8);
        tree1.root.right.right.right = new Node(9);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(7);
        tree1.root.left.left.left = new Node(5);

        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.right.right = new Node(8);
        tree2.root.right.right.right = new Node(9);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(7);
        tree2.root.left.left.left = new Node(5);
         System.out.println(isLeafSimilarTrees(tree1.root, new ArrayList<Integer>())
                 .equals(isLeafSimilarTrees(tree2.root, new ArrayList<Integer>())));
    }
    private static ArrayList<Integer> isLeafSimilarTrees(Node node, ArrayList<Integer> leaves) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.data);
        }
        isLeafSimilarTrees(node.left, leaves);
        isLeafSimilarTrees(node.right, leaves);
        return leaves;
    }
}
