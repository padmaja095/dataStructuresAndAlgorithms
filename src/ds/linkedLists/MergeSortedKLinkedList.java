package ds.linkedLists;

public class MergeSortedKLinkedList {
    Node head;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String args[]){
        int k=3;
        Node arr[] = new Node[k];
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
 
        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
 
        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
        Node head = mergeKLists(arr, k - 1);
        printList(head);
       
    }
    private static Node mergeKLists(Node[] arr, int last) {
        while(last!=0)
        {
            int i=0;int j=last;
            while(i<j)
            {
                arr[i]=mergeTwoSortedLinkedlistUsingRecursion(arr[i], arr[j]);
                i++;j--;
                if(i>=j)
                {last=j;}
            }    
        }
        return arr[0];
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
    
    public static Node insert_at_end(MergeSortedKLinkedList list, int data) {
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