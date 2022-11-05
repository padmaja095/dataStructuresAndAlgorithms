package ds.Tree;

import javax.lang.model.util.ElementScanner14;

public class CountNodesInBinaryTree {

    // using linkedlist
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
        public static void main(String args[])
        {
            int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
            int n = arr.length;
            Node root = constructBST(arr, n);
           
            System.out.println('\n'+"InOrderTraversal:");
            inOrdertraversal(root);
            int count=countNodes(root);
            System.out.println("No of Nodes: "+count);
            int leafnodes=leafNodes(root);
            System.out.println("No of leaf nodes : "+leafnodes);
        }
        private static int leafNodes(Node root) {
            if(root==null)
              return 0;
            else if(root.left==null && root.right==null)
            {
                return 1;
            }
            else{
                return leafNodes(root.left)+leafNodes(root.right);
            }
        }
        private static int countNodes(Node root) {
            if(root==null)
              return 0;
            else return  1+ countNodes(root.left)+countNodes(root.right);
        }
        private static void inOrdertraversal(Node root) {
            if(root==null)
            {
                return;
            }
            else{
                inOrdertraversal(root.left);
                System.out.print(root.data+" ");
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
