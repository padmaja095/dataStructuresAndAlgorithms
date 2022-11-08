package ds.Tree;

public class MirrorOfBinaryTree {
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
        preOrdertraversal(root);
        System.out.println();
        Node rootmirror=mirrorTree(root);
        preOrdertraversal(rootmirror);
    }
    private static Node mirrorTree(Node root) {
        if(root==null)
        {
            return null;
        }
        Node left=mirrorTree(root.left);
        Node right=mirrorTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    private static void preOrdertraversal(Node root) {
        if(root==null)
        {
            return;
        }
        else{
            System.out.print(root.data+" ");
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
