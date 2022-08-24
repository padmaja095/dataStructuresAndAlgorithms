package ds.linkedLists;
import java.io.*;

import javax.swing.ToolTipManager;
public class SplitCircularList {
    //Q: Split the circular SLL into two halves.
    //A: Using Fast and slow pointer, we can find the middle element. and then with ome link modifications. we can split into two halves.
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static void main(String args[])
    {
        SplitCircularList list= new SplitCircularList();
        insert_at_end(list, 1);
        insert_at_end(list, 2);
        insert_at_end(list, 3);
        insert_at_end(list, 4);
        insert_at_end(list, 5);
        printList(list.head);
        list.head.next.next.next.next.next = list.head;
        splitListIntoTwo(list);
    }
    private static void splitListIntoTwo(SplitCircularList list) {
         Node hare=list.head;
         Node tortoise=list.head;
         while(hare.next!=list.head && hare.next.next!=list.head)
         //  first condn: odd && secnd condition: is for even. 
         //in this (1234) -> seperate 12 and 34. but when as it goes till middle number.
         //3 we dont need that. so stop the condition one step before
         {
            hare=hare.next.next;
            tortoise=tortoise.next;
         }
         Node midnext=tortoise.next;
         tortoise.next=list.head;
        if(hare.next==list.head)
        { //odd
            System.out.println("enters");
           hare.next=midnext;
        }
        else{ //even
            hare.next.next=midnext;
        }
    }
    public static SplitCircularList insert_at_end(SplitCircularList list, int data) {
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