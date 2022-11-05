package ds.Tree;
import java.util.ArrayDeque;
import java.util.Queue;
public class MaximumDepthOfBinaryTree {

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

        System.out.println('\n' + "InOrderTraversal:");
        inOrdertraversal(root);
        int maxdepth = maxDepth(root);
        System.out.println("Recursive Approach");
        System.out.println("MaxDepth of the tree: " + maxdepth);
        int maxidepth = maxDepthIterative(root);
        System.out.println("Iterative Approach");
        System.out.println("MaxDepth of the tree: " + maxidepth);
    }

    private static int maxDepthIterative(Node root) {
        int height = -1;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ++height;
            int size = queue.size();
            while (size > 0) {
                --size;
                Node curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return height;
    }
    private static int maxDepth(Node root) {
        if (root == null)
            return 0;
        else {
            int ldepth = maxDepth(root.left);
            int rdepth = maxDepth(root.right);
            return Math.max(ldepth, rdepth) + 1;
        }
    }

    private static void inOrdertraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inOrdertraversal(root.left);
            System.out.print(root.data + " ");
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
