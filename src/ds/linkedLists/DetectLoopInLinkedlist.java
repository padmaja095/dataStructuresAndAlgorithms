package ds.linkedLists;

import javax.swing.ToolTipManager;

public class DetectLoopInLinkedlist {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static DetectLoopInLinkedlist insert_at_end(DetectLoopInLinkedlist list, int data) {
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

    public static void main(String args[]) {
        DetectLoopInLinkedlist detectLoopInLinkedlist = new DetectLoopInLinkedlist();
        insert_at_end(detectLoopInLinkedlist, 1);
        insert_at_end(detectLoopInLinkedlist, 2);
        insert_at_end(detectLoopInLinkedlist, 3);
        insert_at_end(detectLoopInLinkedlist, 4);
        printList(detectLoopInLinkedlist);
        detectLoopInLinkedlist.head.next.next = detectLoopInLinkedlist.head;
        detectLoopInLinkedlist.detectloop(detectLoopInLinkedlist);
    }

    private void detectloop(DetectLoopInLinkedlist detectLoopInLinkedlist) {
        Node hare = detectLoopInLinkedlist.head;
        Node tortoise = detectLoopInLinkedlist.head;
        while (tortoise != null && hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                
                System.out.println("Loop Found in the List ");
                return;
              }
        }
        System.out.println("No loop Found in the list");
    }

    public static void printList(DetectLoopInLinkedlist list) {
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
