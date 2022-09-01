package ds.linkedLists;

public class MergeTwoSortedLinkedlist {
    Node head;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;

        }
    }
public static void main(String args[]){
    MergeTwoSortedLinkedlist list1 = new MergeTwoSortedLinkedlist();
    list1.head=insert_at_end(list1, 2);
    insert_at_end(list1, 4);
    insert_at_end(list1, 6);
    insert_at_end(list1, 8);
    insert_at_end(list1, 10);
    insert_at_end(list1, 14);
    MergeTwoSortedLinkedlist list2 = new MergeTwoSortedLinkedlist();
    list2.head=insert_at_end(list2, 1);
    insert_at_end(list2, 5);
    insert_at_end(list2, 7);
     
    printList(list1.head);
    printList(list2.head);
    Node headNode=mergeTwoSortedLinkedlist(list1, list2);
     printList(headNode);
}
private static Node mergeTwoSortedLinkedlist(MergeTwoSortedLinkedlist list1, MergeTwoSortedLinkedlist list2) {


    Node listHead1=list1.head; Node listHead2=list2.head;
    Node mergelist=null; Node temp=null;
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
        mergelist=listHead2;
        listHead2=listHead2.next;   
    }
    else if(listHead1.data<=listHead2.data){
        mergelist=listHead1;
        listHead1=listHead1.next;
    }
    temp=mergelist;
    while(listHead1!=null && listHead2!=null)
    {
        if(listHead1.data>listHead2.data)
        {
            temp.next=listHead2;
            temp=temp.next;
            listHead2=listHead2.next;
        }
        else{
            temp.next=listHead1;
            temp=temp.next;
            listHead1=listHead1.next;
        }
    }
    temp.next=listHead1!=null? listHead1:listHead2;
    return mergelist;

}
public static void printList(Node node) {
    // Node currNode = list.head;
    System.out.print("LinkedList: ");
    // Traverse through the LinkedList
    while (node != null) {
        System.out.print(node.data + " ");
        // Go to next node
        node = node.next;
    }
}

public static Node insert_at_end(MergeTwoSortedLinkedlist list, int data) {
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
}

