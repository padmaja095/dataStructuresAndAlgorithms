package ds.linkedLists;

import java.util.HashSet;

public class DetectLoopInLikedlistUsinhHashing {
    
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static DetectLoopInLikedlistUsinhHashing insert_at_end(DetectLoopInLikedlistUsinhHashing list, int data) {
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
        DetectLoopInLikedlistUsinhHashing detectLoopInLinkedlist = new DetectLoopInLikedlistUsinhHashing();
        insert_at_end(detectLoopInLinkedlist, 1);
        insert_at_end(detectLoopInLinkedlist, 2);
        insert_at_end(detectLoopInLinkedlist, 3);
        insert_at_end(detectLoopInLinkedlist, 4);
        printList(detectLoopInLinkedlist);
        //to create a loop
        detectLoopInLinkedlist.head.next.next = detectLoopInLinkedlist.head;
        detectLoopInLinkedlist.detectloop(detectLoopInLinkedlist);
    }

    private void detectloop(DetectLoopInLikedlistUsinhHashing detectLoopInLinkedlist) {
       HashSet<Node> checkLoopSet= new HashSet<Node>();
       Node currNode=detectLoopInLinkedlist.head;
       while(currNode!=null)
       {
        if(checkLoopSet.contains(currNode))
        {
            System.out.println("There exists a loop");
            return;
        }
        checkLoopSet.add(currNode);
        currNode=currNode.next;
       }
        System.out.println("No loop Found in the list");
    }

    public static void printList(DetectLoopInLikedlistUsinhHashing list) {
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
