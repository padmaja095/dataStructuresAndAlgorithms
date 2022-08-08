package ds.linkedLists;

import java.nio.file.FileStore;

import javax.lang.model.util.ElementScanner14;
import javax.swing.ToolTipManager;

//Q: find the intersection node if the two linked link intersected. othernull return no intersection
//approach 1: Having nested loops, say first linked list l1 - length is n  and second as l2 -length is m. to find if the intersection is present or not.
//time O(n*m) space - O(1)
//approach 2: find value of n and m . find the diff(n,m). which ever is the largest linked list say  from L1.
// go to the node of difference number. so now we are in equal length from both L1 and L2. 
//if we check by iterating over the L1 and L2 and checking (L1==L2).we can get the intersection if any
//time O(n+m) space- O(1)
//approach 3:  Flyod's cycle detecton algorithm. the one thing is missing is that cycle. 
//so in the end L1 pointing to null point to the L2 starting node. 
//if there is a intersection, cycle will be there. at last remove the pointer manipulation to original. time - O(N+m) space= O(1)
//approach 4: two pointer on both linked list. point to next untill both reaches null and then both one to another list head and second pointer to first list till null. 
//this has to be done untill both are pointer. there you got the intersection node.
public class IntersectionOfSll {
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
        IntersectionOfSll intersectionOfSll1 = new IntersectionOfSll();
        insert_at_end(intersectionOfSll1, 1);
        insert_at_end(intersectionOfSll1, 2);
        insert_at_end(intersectionOfSll1, 3);
        Node temp = insert_at_end(intersectionOfSll1, 4);
        insert_at_end(intersectionOfSll1, 5);
        insert_at_end(intersectionOfSll1, 6);
        insert_at_end(intersectionOfSll1, 7);
        IntersectionOfSll intersectionOfSll2 = new IntersectionOfSll();
        insert_at_end(intersectionOfSll2, 8);
        insert_at_end(intersectionOfSll2, 9);
        insert_at_end(intersectionOfSll2, 10);
        insert_at_end(intersectionOfSll2, 11);
        Node connectivNode = insert_at_end(intersectionOfSll2, 12);
        connectivNode.next=temp;

        printList(intersectionOfSll1);
        printList(intersectionOfSll2);

        findIntersectionOfSll(intersectionOfSll1,intersectionOfSll2);
        findIntersectionUsingFloydAlgo(intersectionOfSll1,intersectionOfSll2);
        findIntersectionUsingTwoPointer(intersectionOfSll1, intersectionOfSll2);

    }

    private static void findIntersectionUsingTwoPointer(IntersectionOfSll intersectionOfSll1,
            IntersectionOfSll intersectionOfSll2) {
        Node firstPtr = intersectionOfSll1.head;
        Node secondPtr = intersectionOfSll2.head;
        while (firstPtr != secondPtr) {
            if (firstPtr != null) {
                firstPtr = firstPtr.next;
            } else {
                firstPtr = intersectionOfSll2.head;
            }
            if (secondPtr != null) {
                secondPtr = secondPtr.next;
            } else {
                secondPtr = intersectionOfSll1.head;
            }
        }
        if (firstPtr != null) {
            System.out.println(firstPtr.data);
        } else {
            System.out.println("No intersection Found");
        }
    }

    // approach 3
    private static void findIntersectionUsingFloydAlgo(IntersectionOfSll intersectionOfSll1,
            IntersectionOfSll intersectionOfSll2) {

        Node temp = intersectionOfSll1.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = intersectionOfSll2.head;
        Node hare = intersectionOfSll1.head;
        Node tortoise = intersectionOfSll1.head;

        while (hare != null && hare.next != null && tortoise != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                tortoise = intersectionOfSll1.head;
                while (tortoise != hare) {
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
                System.out.println("intersection Found in the List " + tortoise.data);
                return;
            }
        }
        System.out.println("No intersection present for this data");

    }

    // approach 2
    private static void findIntersectionOfSll(IntersectionOfSll intersectionOfSll,
            IntersectionOfSll intersectionOfSll2) {
        // find n and m
        int n = 0;
        int m = 0;
        Node L1 = intersectionOfSll.head;
        Node L2 = intersectionOfSll2.head;
        while (L1 != null) {
            n++;
            L1 = L1.next;
        }
        while (L2 != null) {
            m++;
            L2 = L2.next;
        }
        System.out.println(n + " : " + m);
        if (n > m)
            findIntersectionNode(n, n - m, intersectionOfSll.head, intersectionOfSll2.head);
        else
            findIntersectionNode(m, m - n, intersectionOfSll2.head, intersectionOfSll.head);
    }

    private static void findIntersectionNode(int n, int diff, Node largerList, Node smallerList) {
        Node temp = largerList;
        for (int i = 0; i < diff; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
        while (temp != null) {
            if (smallerList == temp) {
                System.out.println("The intersection node is " + temp.data);
                return;
            }
            smallerList = smallerList.next;
            temp = temp.next;
        }
        System.out.println("No intersection present for this data");
    }

    public static Node insert_at_end(IntersectionOfSll list, int data) {
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

    public static void printList(IntersectionOfSll list) {
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
