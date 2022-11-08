package ds.Tree;

public class LowestCommonAncestorOfBST {
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
        int arr[] = { 20,8,22,4,12,10,14,21,28 };
        int n = arr.length;
        Node root = constructBST(arr, n);
        preOrdertraversal(root);
        System.out.println();
        LCA(root,28,21);
       // Node lca=LCAApproach2(root, 28, 21);
       //System.out.println(lca.data);
    }
   

    private static void LCA(Node root, int node1, int node2) {
        if(root==null)
        {return ;}
        if((node1<=root.data) &&(node2>=root.data)|| (node2<=root.data) &&(node1>=root.data))
        {
            System.out.println("LCA"+root.data);
            return;
        }
        LCA(root.left, node1, node2);
        LCA(root.right, node1, node2);
    }
    private static Node LCAApproach2(Node root, int node1, int node2) {
        if(root==null)
        {return null ;}
        if(root.data>Math.max(node1,node2))
        {
            return LCAApproach2(root.left, node1, node2);
        }
        else if(root.data<Math.min(node1,node2))
        {
             return LCAApproach2(root.right, node1, node2);
        }
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
