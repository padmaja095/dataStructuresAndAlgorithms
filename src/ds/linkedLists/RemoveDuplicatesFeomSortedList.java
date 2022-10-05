package ds.linkedLists;

public class RemoveDuplicatesFeomSortedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {
        RemoveDuplicatesFeomSortedList list = new RemoveDuplicatesFeomSortedList();
        insert_at_end(list, 23);
        insert_at_end(list, 28);
        insert_at_end(list, 28);
        insert_at_end(list, 35);
        insert_at_end(list, 39);
        insert_at_end(list, 49);
        insert_at_end(list, 49);
        // insert_at_end(list, 53);
        insert_at_end(list, 53);
        printList(list);
        Node output = list.removeDuplicates(list);
        printList(output);
    }

    private Node removeDuplicates(RemoveDuplicatesFeomSortedList list) {
        Node current = list.head;
        Node dummy = new Node(0);
        dummy.next = list.head;
        Node prev = dummy;
        while (current != null) {
            // Until the current and previous values
            // are same, keep updating current
            while (current.next != null &&
                    prev.next.data == current.next.data)
                current = current.next;
            // If current has unique value i.e current
            // is not updated, Move the prev pointer
            // to next node
            if (prev.next == current)
                prev = prev.next;
            // When current is updated to the last
            // duplicate value of that segment, make
            // prev the next of current*/
            else
                prev.next = current.next;
            current = current.next;
        }
        head=dummy.next;
        printList(head);
        return head;
    }

    public static void printList(RemoveDuplicatesFeomSortedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void printList(Node currNode) {
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static RemoveDuplicatesFeomSortedList insert_at_end(RemoveDuplicatesFeomSortedList list, int data) {
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

}
