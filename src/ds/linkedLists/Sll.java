package ds.linkedLists;

import java.io.*;
// In Singly Linked List
// Insertion at the begining - O(1)
// Insertion at the  end- O(n)
// Deletion at the first -O(1)
// Deletion with a key - O(n)
//Traversal and Search - O(n)
public class Sll {
    Node head; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    // Method to insert a new node at the begining
    public static Sll insert_at_begining(Sll list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            new_node.next = list.head;
            list.head = new_node;
        }
        return list;
    }
    // Method to insert a new node at the end
    public static Sll insert_at_end(Sll list, int data) {
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
    // Method to insert a new node at the middle position with data
    public static Sll insert_in_the_middle(Sll list, int data, int positionData) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.data != positionData) {
                last = last.next;
            }
            Node temp = last.next;
            last.next = new_node;
            new_node.next = temp;
        }
        return list;
    }
    public static Sll delete_node(Sll list, int data) {
        Node deleteNode = list.head;
        Node prev = null;
        if (list.head == null) {
            System.out.println("Linked list is empty");
        }// if the key points in the first element then prev element willl not be there. (prev element s needed in else part for connecting two nodes.in this case it is not needed.) 
        else if (list.head.data == data) {
            Node next = list.head.next;
            list.head = next;
            System.out.println(data + " found and deleted");
        } else {

            while (deleteNode.data != data) {
                prev = deleteNode;
                deleteNode = deleteNode.next;
            }
            prev.next = deleteNode.next;
            System.out.println(data + " found and deleted");
        }
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(Sll list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
    public static void count(Sll list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        int count=0;
        while (currNode != null) {
            count+=1;
            currNode = currNode.next;
        }
        System.out.println("Total Element is : "+count);
    }

    // Driver code
    public static void main(String[] args) {
        /* Start with the empty list. */
        Sll list = new Sll();
        insert_at_begining(list, 1);
        insert_at_begining(list, 2);
        insert_at_begining(list, 3);
        insert_at_begining(list, 4);
        insert_at_end(list, 5);
        insert_at_end(list, 6);
        insert_at_end(list, 7);
        insert_at_end(list, 8);
        insert_in_the_middle(list, 10, 1);
        delete_node(list, 8);
        count(list);
        // Print the LinkedList
        printList(list);
    }
}
