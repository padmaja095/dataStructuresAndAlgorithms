package ds.linkedLists;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class SplitKConsecutiveLinkedList {
     
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
        SplitKConsecutiveLinkedList splitKConsecutiveLinkedList = new SplitKConsecutiveLinkedList();
    insert_at_end(splitKConsecutiveLinkedList, 1);
    insert_at_end(splitKConsecutiveLinkedList, 2);
    insert_at_end(splitKConsecutiveLinkedList, 3);
    insert_at_end(splitKConsecutiveLinkedList, 4);
    insert_at_end(splitKConsecutiveLinkedList, 5);
    insert_at_end(splitKConsecutiveLinkedList, 6);
    insert_at_end(splitKConsecutiveLinkedList, 7);

    printList(splitKConsecutiveLinkedList);
    Node[] list=splitKConsecutiveLinkedList.SplitIntoKLinkedList(splitKConsecutiveLinkedList, 2);
    System.out.print("{");
    for(int i = 0; i < list.length; i++)
    {
        System.out.print("{");
 
        while (list[i] != null)
        {
             
            // Print the value
            System.out.print(list[i].data + "  ");
 
            // Update ans[i]
            list[i]= list[i].next;
 
        }
        System.out.print("}");
        if (i != list.length - 1)
            System.out.print(", ");
    }
    System.out.print("}");    

}
private Node[] SplitIntoKLinkedList(SplitKConsecutiveLinkedList splitKConsecutiveLinkedList, int k) {
    Node root=splitKConsecutiveLinkedList.head;
    Node[] res = new Node[k];
        if (k == 1) {
            res[0] = root;
            return res;
        }
        int n = getLength(root);
        Node pre = null;
        for (int i = 0; i < k; i++) {
            res[i] = root;
            int j = n / k + (i < n % k ? 1 : 0);
            while (root != null && j > 0) {
                pre = root;
                root = root.next;
                j--;
            }
            if (pre != null) pre.next = null;
        }
        return res;

    }
    private int getLength(Node root) {
        int len = 0;
        while (root != null) {
            len++;
            root = root.next;
        }
        return len;
    }
public static Node insert_at_end(SplitKConsecutiveLinkedList list, int data) {
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

public static void printList(SplitKConsecutiveLinkedList list) {
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
