package ds.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {
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
        System.out.println(root.data);
        inOrdertraversal(root);
        //Level order traversal need queue
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node curr=queue.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null)
            {
                queue.add(curr.left);
            }
            if(curr.right!=null)
            {
                queue.add(curr.right); 
            }
        }
    }

    private static void inOrdertraversal(Node root) {
        if(root==null)
        {
            return;
        }
        else{
            System.out.println(root.data);
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
