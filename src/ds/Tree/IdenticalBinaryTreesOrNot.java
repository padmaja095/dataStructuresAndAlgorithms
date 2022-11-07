package ds.Tree;

public class IdenticalBinaryTreesOrNot {
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
        int arr1[] = { 7, 4, 12, 3, 6, 86, 1, 5, 10 };
        int arr2[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
        int n = arr1.length;
        Node rootA = constructBST(arr1, n);
        Node rootB = constructBST(arr2, n);
        inOrdertraversal(rootA);
        //To check whether the both trees are identical or not.
        boolean val=isIdenticalOrNot(rootA,rootB);
        System.out.println("The given two trees are identical or not: "+val);
    }

    private static boolean isIdenticalOrNot(Node rootA, Node rootB) {
        if(rootA==null && rootB==null)
        {
            return true;
        }
        else if(rootA!=null && rootB!=null){
            return (rootA.data==rootB.data) && isIdenticalOrNot(rootA.left, rootB.left) && isIdenticalOrNot(rootA.right, rootB.right);
        }
        return false;
    }

    private static void inOrdertraversal(Node root) {
        if(root==null)
        {
            return;
        }
        else{
            System.out.println("root: "+root.data);
            inOrdertraversal(root.left);
            inOrdertraversal(root.right);
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
