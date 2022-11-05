package ds.Tree;

public class OperationsInBST {

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
        int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
        int n = arr.length;
        Node root = constructBST(arr, n);
        traversal(root);
        Node ele = searchInBST(13, root);
        if (ele == null) {
            System.out.println("element not found");
        } else {
            System.out.println("element found:" + ele.data);
        }
        System.out.println("Min element in this Tree is: "+findMinElement(root));
        System.out.println("Max element in this Tree is: "+findMaxElement(root));

    }
    private static int findMinElement(Node root) {
        Node current=root;
        while(current.left!=null)
        {
            current=current.left;
        }
        return current.data;
    }
    private static int findMaxElement(Node root) {
        Node current=root;
        while(current.right!=null)
        {
            current=current.right;
        }
        return current.data;
    }
    private static Node searchInBST(int data, Node root) {
        if (root == null || root.data == data) {
            return root;
        }
        if (data < root.data) {
            return searchInBST(data, root.left);
        }
        return searchInBST(data, root.right);
    }
    private static void traversal(Node root) {
        if (root == null) {
            return;
        } else {
             System.out.print(root.data+" ");
             traversal(root.left);
             traversal(root.right);
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
