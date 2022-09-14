package ds.linkedLists;

public class ReverseLinkedlistFromMtoNNodes {
    Node head;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;

        }
    }

    public static void main(String args[]) {
        ReverseLinkedlistFromMtoNNodes reverseAlternativeKNodes = new ReverseLinkedlistFromMtoNNodes();
        insert_at_end(reverseAlternativeKNodes, 1);
        insert_at_end(reverseAlternativeKNodes, 2);
        insert_at_end(reverseAlternativeKNodes, 3);
        insert_at_end(reverseAlternativeKNodes, 4);
        insert_at_end(reverseAlternativeKNodes, 5);
        insert_at_end(reverseAlternativeKNodes, 6);
        reverseAlternativeKNodes.printList(reverseAlternativeKNodes.head);
        Node node = reverseAlternativeKNodes.reverseFromMtoNnode(reverseAlternativeKNodes.head, 1, 4);
        reverseAlternativeKNodes.printList(node);
    }
    private Node reverseFromMtoNnode(Node headNode, int m, int n) {
        int k = n - m + 1;
        Node current = headNode;
        Node previous = null;
        for (int i = 0; i < m - 1; i++) {
            if (current.next != null) {
                previous = current;
                current = current.next;
            } else {
                System.out.println("The Given M is incorrect: M is larger than list size");
            }
        }
        Node curr = current;
        Node nxt;
        Node prev = null;
        int count = 0;
        while (curr != null && count < k) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            count++;
        }
        if (m == 1) {
            // Incase of reversing needs includes headnode
            headNode = prev;
            current.next = curr;
            return headNode;
        }
        if (previous != null) {
            previous.next = prev;
        }
        if (current != null) {
            current.next = curr;
        }
        return headNode;
    }

    public static void printList(Node node) {
        // Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (node != null) {
            System.out.print(node.data + " ");
            // Go to next node
            node = node.next;
        }
    }

    public static Node insert_at_end(ReverseLinkedlistFromMtoNNodes list, int data) {
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
        return new_node;
    }
}