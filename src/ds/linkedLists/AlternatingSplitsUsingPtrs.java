package ds.linkedLists;

public class AlternatingSplitsUsingPtrs {
    public static Node HeadA=null;
    public static Node HeadB=null;

    Node head;
   
    static class Node {
       int data;
       Node next;

       Node(int d) {
           data = d;
           next = null;
       }
       Node()
       {}
   }

   public static void main(String args[]) {
    AlternatingSplitsUsingPtrs list = new AlternatingSplitsUsingPtrs();
       insert_at_end(list, 1);
       insert_at_end(list, 2);
       insert_at_end(list, 3);
       insert_at_end(list, 4);
       insert_at_end(list, 5);
       insert_at_end(list, 6);
       insert_at_end(list, 7);

       printList(list);
       list.SplitLinkedList(list);
       printnode(HeadA);
       printnode(HeadB);
   }

   private void SplitLinkedList(AlternatingSplitsUsingPtrs list) {
       Node currNode = list.head;
       HeadA=currNode;
       HeadB=currNode.next;
       if (currNode == null || currNode.next == null) {
        return; // we have nothing to split, return
    }
       while(currNode!=null && currNode.next!=null)
       {
        Node temp=currNode.next;
        currNode.next=temp.next;
        if(currNode.next.next != null)
        {
            temp.next=temp.next.next;
        }
        else{
            temp.next=null;
            return;
        }
        currNode=currNode.next;
       }
   }
   public static Node insert_at_end(AlternatingSplitsUsingPtrs list, int data) {
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

   public static void printList(AlternatingSplitsUsingPtrs list) {
       Node currNode = list.head;
       System.out.print("LinkedList: ");
       // Traverse through the LinkedList
       while (currNode != null) {
           System.out.print(currNode.data + " ");
           // Go to next node
           currNode = currNode.next;
       }
   }
   public static void printnode(Node node) {
    Node curr=node;
    System.out.print("LinkedList: ");
    // Traverse through the LinkedList
    while (curr != null) {
        System.out.print(curr.data + " ");
        // Go to next node
        curr = curr.next;
    }
}
}
