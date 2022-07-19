package ds.linkedLists;

import java.net.http.HttpHeaders;

// In Doubly Linked List
// Insertion at the begining - O(1)
// Insertion at the  end- O(n)
// Deletion at the first -O(1)
// Deletion with a key - O(n)
//Traversal and Search - O(n)
public class Dll {
    Node head;

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    public static void main(String args[]) {
        /* Start with the empty list. */
        Dll list = new Dll();
        insert_at_begining(list, 1);
        insert_at_begining(list, 2);
        insert_at_begining(list, 3);
        insert_at_begining(list, 4);
        insert_at_end(list, 5);
        insert_at_end(list, 6);
        insert_at_end(list, 7);
        insert_at_end(list, 8);
        insert_in_the_middle(list, 10, 1);
        delete_node(list, 4);
        count(list);
        // Print the LinkedList
        printList(list);

    }

    private static void printList(Dll list) {
        if (list.head != null) {
            Node currNode = list.head;
            System.out.print("LinkedList: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        }
    }

    private static void count(Dll list) {

        if (list.head != null) {
            int counter = 1;
            Node currNode = list.head;
            while (currNode != null) {
                counter++;
                currNode = currNode.next;
            }
            System.out.println("No of elements present in the list is: " + counter);
        }

    }

    private static void delete_node(Dll list, int i) {
        if (list.head == null) {
            System.out.println("List is null. Nothing to delete here");
        } else if (list.head.data == i) {
            Node temp = list.head;
            list.head = temp.next;
            temp.next.prev = null;
            System.out.println(i + " found and deleted");

        } else {
            Node currNode = list.head;
            while (currNode.data != i) {
                currNode = currNode.next;
            }
            currNode.prev.next = currNode.next;
            if (currNode.next != null) {
                currNode.next.prev = currNode.prev;
            }
            System.out.println(i + " found and deleted");
        }
    }

    private static void insert_in_the_middle(Dll list, int data, int positionData) {
        // insert in the middle: before the given positionData
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node currNode = list.head;
            while (currNode.data != positionData) {
                currNode = currNode.next;
            }
            new_node.prev = currNode.prev;
            currNode.prev.next = new_node;
            currNode.prev = new_node;
            new_node.next = currNode;
        }

    }

    private static void insert_at_end(Dll list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node currNode = list.head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = new_node;
            new_node.prev = currNode;

        }

    }

    private static void insert_at_begining(Dll list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;

        } else {
            new_node.next = list.head;
            new_node.next.prev = new_node;
            list.head = new_node;
        }
    }

}
