package ds.Tree;

public class isTwoTreesAreSame {
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
        isTwoTreesAreSame tree = new isTwoTreesAreSame();
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

        tree.root2 = new Node(1);
        tree.root2.left = new Node(3);
        tree.root2.right = new Node(2);
        tree.root2.left.left = new Node(5);
        tree.root2.left.left.left = new Node(6);
        System.out.println(tree.isSame2(tree.root1, tree.root2));
    }
    private boolean isSame(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            return false;
        }
        if (node1.data != node2.data) {
            return false;
        }
        if (!isSame(node1.left, node2.left) || !isSame(node1.right, node2.right)) {
            return false;
        }
        return true;
    }
    private boolean isSame2(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if(node1!=null && node2!=null)
        {
            return (node1.data==node2.data) && isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
        }
        return false;
    }
}
