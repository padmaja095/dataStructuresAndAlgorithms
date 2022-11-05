package ds.Tree;

import java.util.Stack;

public class TraversalsOfBST {
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
        System.out.println("PreOrderTraversal:");
        preOrdertraversal(root);
        System.out.println('\n'+"InOrderTraversal:");
        inOrdertraversal(root);
        System.out.println('\n'+"PostOrderTraversal:");
        postOrdertraversal(root);
        System.out.println('\n'+"Iterative PreOrderTraversal:");
        iterativePreorderTraversal(root);
        System.out.println('\n'+"Iterative InOrderTraversal:");
        iterativeInorderTraversal(root);
        //System.out.println("Iterative PreOrderTraversal:");
    }

    private static void iterativeInorderTraversal(Node root) {
        Node current=root;
        Stack<Node> stack = new Stack<>();
        while(true)
        {
            if(current!=null)
            {
                stack.push(current);
                current=current.left;
            }else if(!stack.isEmpty())
            {
                current=stack.pop();
                System.out.print(current.data+" ");
                current=current.right; 
            }
            else{
                break;
            }

        }
    }

    private static void iterativePreorderTraversal(Node root) {
        if(root == null)
        {return;}
        Stack<Node> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node current= stack.pop();
            System.out.print(current.data+" ");
            if(current.right!=null)
            {
                stack.push(current.right);
            }
            if(current.left!=null)
            {
                stack.push(current.left);
            }

        }


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
    private static void postOrdertraversal(Node root) {
        if(root==null)
        {
            return;
        }
        else{
            postOrdertraversal(root.left);
            postOrdertraversal(root.right);
            System.out.print(root.data+" ");
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
