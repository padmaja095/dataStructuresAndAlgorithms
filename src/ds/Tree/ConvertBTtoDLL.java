package ds.Tree;

public class ConvertBTtoDLL {
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
    Node head;
    static Node prev = null;

    public void convertBinaryTreeToDLL(Node node) {
        if (node == null) {
            return;
        }
        convertBinaryTreeToDLL(node.left);
        if (prev == null) {
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        convertBinaryTreeToDLL(node.right);
    }
    public static void main(String args[]) {
        ConvertBTtoDLL tree = new ConvertBTtoDLL();
        /*
         * Construct the following binary tree
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 8
         * /    \
         * 7     9
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.convertBinaryTreeToDLL(tree.root);
        printDLL(tree.head);
    }
    private static void printDLL(Node head2) {
        Node curr = null;
        while (head2 != null) {
            System.out.print(head2.data + " ");
            head2 = head2.right;
            if (head2 != null)
                curr = head2;
        }
        System.out.println();
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.left;
        }
    }
}
