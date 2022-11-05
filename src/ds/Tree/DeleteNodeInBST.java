package ds.Tree;
public class DeleteNodeInBST {
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
        int arr[] = { 2, 1, 33, 0, 25, 40, 11, 34, 7, 12, 36, 13 };
        int n = arr.length;
        Node root = constructBST(arr, n);
        System.out.println('\n'+"InOrderTraversal:");
        inOrdertraversal(root);
        deleteNodeInBST(root,33);
        System.out.println('\n'+" After deleting InOrderTraversal:");
        inOrdertraversal(root);
      }
    private static Node deleteNodeInBST(Node root,int value) {
        if(root==null)
        {return root;}
        if(root.data>value)
        {
            root.left=deleteNodeInBST(root.left, value);
        }else if(root.data<value)
        {
            root.right=deleteNodeInBST(root.right, value);
        }
        else{
            if(root.left==null && root.right==null)
            {
                root=null;
            }
            else if(root.right!=null)
            {
               //get the sucessor node
               root.data=sucessorNode(root);
               root.right=deleteNodeInBST(root.right, root.data);
            }
            else{
                 //get the predeccesor node
                 root.data=predecessorNode(root);
                 root.left=deleteNodeInBST(root.left, root.data);
            }
        }
        return root;

    }
    private static int predecessorNode(Node root) {
        root=root.left;
        while(root.right!=null)
        {
            root=root.right;

        }
        return root.data;
    }
    private static int sucessorNode(Node root) {
        root=root.right;
        while(root.left!=null)
        {
            root=root.left;

        }
        return root.data;
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
