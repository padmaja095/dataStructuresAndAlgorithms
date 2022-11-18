package ds.Tree;

public class BoundaryTraversal {

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
        BoundaryTraversal tree = new BoundaryTraversal();
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
        tree.root.right.left.right = new Node(9);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.left.left = new Node(10);
        tree.boundaryTraversalRecursion(tree.root);
    }

    private void boundaryTraversalRecursion(Node node) {
        System.out.println(node.data);
        printLeftBoundaryNodes(node.left);
        System.out.println("---");
        printLeaves(node);
        System.out.println("---");
        printRightBoundaryNodes(node.right);
    }

    private boolean printRightBoundaryNodes(Node node) {
        if (node.right == null && node.left == null) {
            return true;
        }
        if (printRightBoundaryNodes(node.right == null ? node.left : node.right)) {
            System.out.println(node.data);
            return true;
        }
        return false;
    }

    private void printLeaves(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println(node.data);
        }
        printLeaves(node.left);
        printLeaves(node.right);
    }

    private void printLeftBoundaryNodes(Node node) {
        if (node.right == null && node.left == null) {
            return;
        } else {
            System.out.println(node.data);
        }
        printLeftBoundaryNodes(node.left == null ? node.right : node.left);
    }
}