package ds.Tree;

public class MorrisInorderTraversal {

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

    public void inorderTraversal(Node node) {
        Node curr;
        Node prev;
        if (node == null) {
            return;
        }
        curr = node;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }

                else {
                    prev.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }

            }

        }
/**/
    }

    public static void main(String args[]) {
        MorrisInorderTraversal tree = new MorrisInorderTraversal();
        /*
         * Construct the following binary tree
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 8
         * /    \
         * 7    9
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.inorderTraversal(tree.root);

    }

}
