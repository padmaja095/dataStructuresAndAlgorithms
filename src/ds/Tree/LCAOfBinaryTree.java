package ds.Tree;

public class LCAOfBinaryTree {
    // using linkedlist
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 20, 8, 22, 4, 12, 10, 14, 21, 28 };
        int n = arr.length;
        Node root = constructBST(arr, n);
        preOrdertraversal(root);
        System.out.println();
        Node lca = LCA(root, 4, 15);
        System.out.println("LCS:" + lca.data);

    }
    private static Node LCA(Node root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        if (root.data == node1 || root.data == node2) {
            return root;
        }
        Node leftSearch = LCA(root.left, node1, node2);
        Node rightSearch = LCA(root.right, node1, node2);
        if (leftSearch == null) {
            return rightSearch;
        }
        if (rightSearch == null) {
            return leftSearch;
        }
        // below case is when
        // 1
        // / \
        // 2 2 when lca(2,3)-> 1. which is incorrect,
        // if condition to check incase of returning root. either node1 and node2 should
        // have both the values. and not the same.
        if ((leftSearch.data == node1 && rightSearch.data == node2)
                || (leftSearch.data == node2 && rightSearch.data == node1)) {
            return root;
        }
        return null;
    }

    private static void preOrdertraversal(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preOrdertraversal(root.left);
            preOrdertraversal(root.right);
        }
    }

    private static Node constructBST(int[] arr, int n) {
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = treeComparisonRecursion(root, arr[i]);
        }
        return root;
    }

    private static Node treeComparisonRecursion(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.data) {
            root.left = treeComparisonRecursion(root.left, data);
        } else {
            root.right = treeComparisonRecursion(root.right, data);
        }
        return root;
    }

    static Node getNode(int data) {
        Node newNode = new Node(data);
        newNode.left = newNode.right = null;
        return newNode;
    }
}
