package ds.linkedLists;

public class MergeSortedlinkedlistAndFlatten {
    Node head;

    static class Node {
        Node right;
        Node down;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String args[]){
        Node head= new Node(5);
        head.right=new Node(13);
        head.right.right=new Node(1);
        head.right.right.right= new Node(20);

        head.down=new Node(7);
        head.down.down=new Node(9);
        head.down.down.down=new Node(12);

        head.right.down=new Node(15);
        head.right.down.down= new Node(19);

        head.right.right.down= new Node(2);
        head.right.right.down.down= new Node(3);

        head.right.right.right.down= new Node(30);
        head.right.right.right.down.down= new Node(40);

        Node headPtr = mergeLists(head);
        printList(headPtr);
       
    }
    private static Node mergeLists(Node head) {
        Node rem= head.right;
        while(rem!=null)
        {
            Node l2= rem;
            rem=rem.right;
            head=mergeTwoSortedLinkedlistUsingRecursion(head, l2);
        }
        return head;
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
            listHead2.down=mergeTwoSortedLinkedlistUsingRecursion(listHead1,listHead2.down);
            return listHead2;
        }
        else {
            listHead1.down=mergeTwoSortedLinkedlistUsingRecursion(listHead1.down,listHead2);
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
            node = node.down;
        }
    }
    
    public static Node insert_at_end(MergeSortedlinkedlistAndFlatten list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.down != null) {
                last = last.down;
            }
            last.down = new_node;
        }
        return new_node;
    }
}
