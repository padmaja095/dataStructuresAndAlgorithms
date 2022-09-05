package ds.linkedLists;

import java.util.HashSet;

public class FindUnionAndIntersectionUsingHashing {
    // Q: Given two linked list S1: 6->4->2->8->10-> S2: 2->1->3->4
    // union list is : 6->4->2->8->10->1->3 and intersection-list is: 2->4
    // Approach 1:Using HashMap
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
        FindUnionAndIntersectionUsingHashing fui = new FindUnionAndIntersectionUsingHashing();
        // S1: 6->4->2->8->10-> S2: 2->1->3->4
        Node S1head = new Node(6);
        S1head.next = new Node(4);
        S1head.next.next = new Node(2);
        S1head.next.next.next = new Node(8);
        S1head.next.next.next.next = new Node(10);
        Node S2head = new Node(2);
        S2head.next = new Node(1);
        S2head.next.next = new Node(3);
        S2head.next.next.next = new Node(4);
        fui.findUnionIntersection(S1head, S2head);
    }
    private void findUnionIntersection(Node s1head, Node s2head) {
        FindUnionAndIntersectionUsingHashing unionList = new FindUnionAndIntersectionUsingHashing();
        FindUnionAndIntersectionUsingHashing intersectionList = new FindUnionAndIntersectionUsingHashing();
        Node s1ptr = s1head;
        Node s2ptr = s2head;
        Node unionPtr = null;
        Node intersectionPtr = null;
        HashSet<Integer> unionHashSet = new HashSet<Integer>();
        while (s1ptr != null) {
            unionHashSet.add(s1ptr.data);
            Node new_node = new Node(s1ptr.data);
            if (unionList.head == null) {
                unionList.head = new_node;
                unionPtr = new_node;
            } else {
                unionPtr.next = new_node;
                unionPtr = new_node;
            }
            s1ptr = s1ptr.next;
        }
        while (s2ptr != null) {
            if (!unionHashSet.contains(s2ptr.data)) {
                Node new_node = new Node(s2ptr.data);
                if (unionList.head == null) {
                    unionList.head = new_node;
                    unionPtr = new_node;
                } else {
                    unionPtr.next = new_node;
                    unionPtr = new_node;
                }
            } else {
                Node new_node = new Node(s2ptr.data);
                if (intersectionList.head == null) {
                    intersectionList.head = new_node;
                    intersectionPtr = new_node;
                } else {
                    intersectionPtr.next = new_node;
                    intersectionPtr = new_node;
                }
            }
            s2ptr = s2ptr.next;
        }
        printList(unionList);
        printList(intersectionList);
    }
    public static void printList(FindUnionAndIntersectionUsingHashing list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
    public static void printList(Node list) {
        Node currNode = list;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
