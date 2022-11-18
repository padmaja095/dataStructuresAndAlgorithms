package ds.Tree;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalTraversalOfBT {
    public static Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

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

    public void verticalTraversal(Node node, int point, Map<Integer, ArrayList<Integer>> map) {
        if (node == null) {
            return;
        }
        verticalTraversal(node.left, point + 1, map);
        if (!map.containsKey(point)) {
            map.put(point, new ArrayList<>());
        }
        map.get(point).add(node.data);
        // System.out.println(node.data+" : "+point);
        verticalTraversal(node.right, point - 1, map);
    }
    public static void main(String args[]) {
        VerticalTraversalOfBT tree = new VerticalTraversalOfBT();
        /*
         * Construct the following binary tree
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 8
         * / \
         * 7 9
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.verticalTraversal(tree.root, 0, map);
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}
