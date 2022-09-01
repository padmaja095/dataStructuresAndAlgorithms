package ds.linkedLists;

public class MergeSort {
   Node head;
static class Node{
    int data;
    Node next;
    Node (int data) {
        this.data = data;
    }
}

public static void main(String args[])
{
    MergeSort ms = new MergeSort();
    insert_at_end(ms, 10);
    insert_at_end(ms, 8);
    insert_at_end(ms, 1);
    insert_at_end(ms, 5);
    insert_at_end(ms, 2);
    insert_at_end(ms, 16);
    insert_at_end(ms, 13);
    printList(ms);
    Node node=ms.mergeSort(ms.head);
    printList(node);
}
private Node mergeSort(Node headNode) {
    if(headNode==null || headNode.next==null)
    {
        return headNode;
    }
        Node middle= getMiddleNode(headNode);
        Node middleNext= middle.next;
        middle.next=null;
        Node left= mergeSort(headNode);
        Node right=mergeSort(middleNext);
        Node sortedNode=mergeTwoSortedLinkedlistUsingRecursion(left, right);
        return sortedNode;
}
private Node getMiddleNode(Node headNode) {
    if (headNode == null)
        return headNode;
    Node tortoise=headNode; 
    Node hare=headNode;
    while(hare.next!=null && hare.next.next!=null)
    {
        tortoise=tortoise.next;
        hare=hare.next.next;
    }
    return tortoise;
}
private static Node mergeTwoSortedLinkedlistUsingRecursion(Node listHead1, Node listHead2) {
    if(listHead1==null)
    {
        return listHead2;
    }
    else if (listHead2==null)
    {
        return listHead1;
    }
    if(listHead1.data>listHead2.data)
    {
        listHead2.next=mergeTwoSortedLinkedlistUsingRecursion(listHead1,listHead2.next);
        return listHead2;
    }
    else {
        listHead1.next=mergeTwoSortedLinkedlistUsingRecursion(listHead1.next,listHead2);
        return listHead1;
    }
}

public static MergeSort insert_at_end(MergeSort list, int data) {
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
public static void printList(MergeSort list) {
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
