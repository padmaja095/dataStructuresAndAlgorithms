package ds.Tree;

public class AncestorOfNodeInBinaryTre {
 // using linkedlist
 static class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
    }
}
	Node root;
	/* If target is present in tree, then prints the ancestors
	and returns true, otherwise returns false. */
	boolean printAncestors(Node node, int target)
	{
		/* base cases */
		if (node == null)
			return false;
		if (node.data == target)
			return true;
		/* If target is present in either left or right subtree
		of this node, then print this node */
		if (printAncestors(node.left, target)
				|| printAncestors(node.right, target))
		{
			System.out.print(node.data + " ");
			return true;
            //this return true is to print the ancestor other than parent.
		}
		/* Else return false */
		return false;
	}
	public static void main(String args[])
	{
		AncestorOfNodeInBinaryTre tree = new AncestorOfNodeInBinaryTre();
		/* Construct the following binary tree
				1
				/ \
			   2   3
			  / \    \
			4 5      8
			/         \
		   7           9
		*/
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
        tree.root.right.right = new Node(8);
        tree.root.right.right.right = new Node(9);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(7);
		tree.printAncestors(tree.root, 9);
	}
}

