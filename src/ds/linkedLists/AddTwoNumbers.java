package ds.linkedLists;

public class AddTwoNumbers {
    // Q: Add two very big numbers.
    // approach : using singly linked list.
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String args[]) {
        AddTwoNumbers list = new AddTwoNumbers();
        Node first = null;
        first = push(first, 4);
        first = push(first, 8);
        first = push(first, 8);
        Node second = null;
        second = push(second, 6);
        second = push(second, 4);
        second = push(second, 4);
        second = push(second, 1);
        Node outputlist = addLists(first, second);
        printlist(outputlist);
    }
    private static void printlist(Node list) {
        if (list != null) {
            Node currNode = list;
            Node pre = list;
            System.out.print("LinkedList: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                pre = currNode;
                currNode = currNode.next;
            }
        }
    }

    private static Node addLists(Node first, Node second) {
        Node outputHead = null;
        int sum = 0;
        int q = 0;
        int r;
        while (first != null || second != null) {
            sum = q + (first != null ? first.data : 0) + (second != null ? second.data : 0);
            r = sum % 10; // 18/10 r=8
            q = sum / 10; // 18/10 q=1
            Node new_node = new Node(r);
            if (outputHead == null) {
                outputHead = new_node;
            } else {
                new_node.next = outputHead;
                outputHead = new_node;
            }
            if (first != null)
                first = first.next;
            if (second != null)
                second = second.next;
        }
        if (q > 0) {
            Node new_node = new Node(q);
            new_node.next = outputHead;
            outputHead = new_node;
        }
        return outputHead;
    }
    private static Node push(Node first, int data) {
        Node new_node = new Node(data);
        new_node.next = first;
        first = new_node;
        return first;
    }
}