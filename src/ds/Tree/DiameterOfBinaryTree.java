package ds.Tree;

public class DiameterOfBinaryTree {
    //To find the longest path between two lead nodes.
    //This can be solved by finding the height of the left subtree +height of right sub tree +2.(this 2 is to include 2 path from root(left path and right path))
      // using linkedlist
      static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
     Integer diameter;
      public DiameterOfBinaryTree(int diameter)
      {
          this.diameter=diameter;   
      }
      public DiameterOfBinaryTree() {
        // TODO Auto-generated constructor stub
    }
    Node root;
    public static void main(String args[]) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree(Integer.MIN_VALUE);
        /*
         * Construct the following binary tree
         * 20
         * / \
         * 12 8
         * / \ /\
         * 6 6 3 1
         *  \     \
         *   1     5
         */
        tree.root = new Node(20);
        tree.root.left = new Node(12);
        tree.root.right = new Node(8);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(1);
        tree.root.right.right.right = new Node(5);
        tree.root.left.left = new Node(6);
        tree.root.left.left.right = new Node(1);
        tree.root.left.right = new Node(6);
        tree.diameterOfBT(tree.root,tree);
        System.out.println(tree.diameter);
    }

    private static int diameterOfBT(Node node,DiameterOfBinaryTree tree) {
        if(node==null)
        {
            return -1;
        }
        int l= diameterOfBT(node.left, tree);
        int r=diameterOfBT(node.right, tree);
        tree.diameter=Math.max(tree.diameter, l+r+2);
        return (1+Math.max(l,r));
    }
    
}
