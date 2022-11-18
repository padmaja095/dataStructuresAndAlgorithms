package ds.Tree;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

//Time complexity= linear search ->O(n) *n elemnts to make node O(n)= (as we are doing linear search for every 1 node)=O(n^2)
// space complexity= recusrion , so it uses stach =O(n)
// this can be optimizied. instead of using linear search, the inArr can be stored in hashmap = key - array vals and value -index
// As reading is O(1) time in hashmap the time complexitybecomes-> O(1)* O(n)=O(n)times
//space remains the same -> O(n)+O(n)-> program stack+hashmap=O(n)
public class ConstructBTFromInorderAndPostOrderTraversals {
    static Map<Integer, Integer> inOrderMap = new HashMap<>();

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
        int[] inArr = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        for (int i = 0; i < inArr.length; i++) {
            inOrderMap.put(inArr[i], i);
        }
        int[] postArr = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        Node root = buildTree(inArr, postArr, 0, inArr.length - 1, 0, postArr.length - 1);
        levelOrderTraversal(root);

    }

    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    private static Node buildTree(int[] inArr, int[] postArr, int startIn, int endIn, int startpost, int endPost) {
        if (startIn > endIn) {
            return null;
        }
        if (startIn == endIn) {
            return makeNode(inArr[startIn]);
        }
        Node n = makeNode(postArr[endPost]);
        int idx = searchRoot(inArr, startIn, endIn, postArr[endPost]);
        n.left = buildTree(inArr, postArr, startIn, idx - 1, startIn, idx - 1);
        n.right = buildTree(inArr, postArr, idx + 1, endIn, idx, endIn - 1);
        return n;
    }

    private static int searchRoot(int[] inArr, int startIn, int endIn, int val) {
        // Linear search approach
        // for(int i=0;i<inArr.length;i++)
        // {
        // if(inArr[i]==val)
        // {
        // return i;
        // }
        // }
        // storing vals in hashmap(inOrderMap) and retriving can consume only O(1) for
        // every node
        return inOrderMap.get(val);
    }

    private static Node makeNode(int i) {
        return new Node(i);
    }
}
