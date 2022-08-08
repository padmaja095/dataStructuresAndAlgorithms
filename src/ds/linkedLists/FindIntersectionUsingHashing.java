package ds.linkedLists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class FindIntersectionUsingHashing {
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
        FindIntersectionUsingHashing intersectionOfSll1 = new FindIntersectionUsingHashing();
        insert_at_end(intersectionOfSll1, 1);
        insert_at_end(intersectionOfSll1, 2);
        insert_at_end(intersectionOfSll1, 3);
        Node temp = insert_at_end(intersectionOfSll1, 4);
        insert_at_end(intersectionOfSll1, 5);
        insert_at_end(intersectionOfSll1, 6);
        insert_at_end(intersectionOfSll1, 7);
        FindIntersectionUsingHashing intersectionOfSll2 = new FindIntersectionUsingHashing();
        insert_at_end(intersectionOfSll2, 8);
        insert_at_end(intersectionOfSll2, 9);
        insert_at_end(intersectionOfSll2, 10);
        insert_at_end(intersectionOfSll2, 11);
        Node connectivNode = insert_at_end(intersectionOfSll2, 12);
        connectivNode.next = temp;

        printList(intersectionOfSll1);
        printList(intersectionOfSll2);

        findIntersectionUsingHashing(intersectionOfSll1, intersectionOfSll2);

    }

    private static void findIntersectionUsingHashing(FindIntersectionUsingHashing intersectionOfSll1,
            FindIntersectionUsingHashing intersectionOfSll2) {
        HashSet<Node> firstLLTable = new HashSet<>();
        Node firstLL = intersectionOfSll1.head;
        while (firstLL != null) {
            firstLLTable.add(firstLL);
            firstLL = firstLL.next;
        }
        Node secondLL = intersectionOfSll2.head;
        while (secondLL != null) {
            if (firstLLTable.contains(secondLL)) {
                System.out.println("The intersection Node found " + secondLL.data);
                return;
            }
            secondLL = secondLL.next;
        }
    }

    public static Node insert_at_end(FindIntersectionUsingHashing list, int data) {
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
        // return list;
        return new_node;
    }

    public static void printList(FindIntersectionUsingHashing list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
