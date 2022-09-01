package ds.linkedLists;

public class MergeTwoSortedLinkedListUsinhRecursion {
    Node head;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;

        }
    }
    public static void main(String args[]){
        MergeTwoSortedLinkedListUsinhRecursion list1 = new MergeTwoSortedLinkedListUsinhRecursion();
        list1.head=insert_at_end(list1, 2);
        insert_at_end(list1, 4);
        insert_at_end(list1, 6);
        insert_at_end(list1, 8);
        insert_at_end(list1, 10);
        insert_at_end(list1, 14);
        MergeTwoSortedLinkedListUsinhRecursion list2 = new MergeTwoSortedLinkedListUsinhRecursion();
        list2.head=insert_at_end(list2, 1);
        insert_at_end(list2, 5);
        insert_at_end(list2, 7);
        printList(list1.head);
        printList(list2.head);
        Node headNode=mergeTwoSortedLinkedlistUsingRecursion(list1.head, list2.head);
         printList(headNode);
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
    
    public static Node insert_at_end(MergeTwoSortedLinkedListUsinhRecursion list, int data) {
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
