package ds.linkedLists;

import javax.security.auth.callback.TextInputCallback;

public class SwapNodesInPairs {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String args[]) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        insert_at_end(swapNodesInPairs, 1);
        insert_at_end(swapNodesInPairs, 2);
        insert_at_end(swapNodesInPairs, 3);
        insert_at_end(swapNodesInPairs, 4);
        insert_at_end(swapNodesInPairs, 5);
        insert_at_end(swapNodesInPairs, 6);
        insert_at_end(swapNodesInPairs, 7);
        insert_at_end(swapNodesInPairs, 8);
        insert_at_end(swapNodesInPairs, 9);
        printList(swapNodesInPairs);
        Node node = swapNodesInPairs.swapKnodes(swapNodesInPairs.head, swapNodesInPairs.head, 3);
        printList(node);
    }

    private Node swapKnodes(Node q, Node cuur, int k) {
        Node temp = q;
        for (int i = 0; i < k; i++) {
            if (temp.next != null) {
                temp = temp.next;
            } else if (i != k - 1 || temp.next != null) {
                return q;
            }
        }
        Node current = cuur;
        Node nxt;
        Node prev = null;
        int count = 0;
        while (current != null && count < k) {
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
            count++;
        }
        if (cuur != null) {
            cuur.next = current;
        }
        if (current != null) {
            cuur.next = swapKnodes(temp, current, k);
        }
        return prev;
    }

    public static SwapNodesInPairs insert_at_end(SwapNodesInPairs list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(SwapNodesInPairs list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void printList(Node list) {
        Node currNode = list;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
}