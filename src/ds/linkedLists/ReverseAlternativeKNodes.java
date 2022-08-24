package ds.linkedLists;

public class ReverseAlternativeKNodes {
    static Node head;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;

        }
    }

    public static void main(String args[]) {
        ReverseAlternativeKNodes reverseAlternativeKNodes = new ReverseAlternativeKNodes();
        insert_at_end(reverseAlternativeKNodes, 1);
        insert_at_end(reverseAlternativeKNodes, 2);
        insert_at_end(reverseAlternativeKNodes, 3);
        insert_at_end(reverseAlternativeKNodes, 4);
        insert_at_end(reverseAlternativeKNodes, 5);
        insert_at_end(reverseAlternativeKNodes, 6);
         insert_at_end(reverseAlternativeKNodes, 7);
         insert_at_end(reverseAlternativeKNodes, 8);
         insert_at_end(reverseAlternativeKNodes, 9);
         insert_at_end(reverseAlternativeKNodes, 10);
         insert_at_end(reverseAlternativeKNodes, 11);
         insert_at_end(reverseAlternativeKNodes, 12);
         insert_at_end(reverseAlternativeKNodes, 13);
         insert_at_end(reverseAlternativeKNodes, 14);
        reverseAlternativeKNodes.printList(head);
         head = reverseAlternativeKNodes.kAlternateNodes(reverseAlternativeKNodes.head, 3);
         reverseAlternativeKNodes.printList(head);
    }

    private Node kAlternateNodes(Node node, int k) {
        //reversing the first k nodes
        Node current=node;
        Node prev=null;
        Node next=null;
        int count=0;
        while(current!=null && count<k )
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
        //after reversing the k nodes connect the kth node next nodes.
        if(node!=null)
        {
            node.next=current;
        }
        //move thru k nodes without doing anything
        count=0;
        while(count<k-1 && current!=null)
        {
            current=current.next;
            count++;
        }
        //recursively calling the kalternate Method to do the same.
        // return (prev) of this method is first of k nodes. current.next which is (123456) 6 should be connected with 9 [(789) reversed(987)]
        if(current!=null)
        {
            current.next=kAlternateNodes(current.next, k);
        }
        // parent method call prev contains first node which is head (3).
        return prev;

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

    public static Node insert_at_end(ReverseAlternativeKNodes list, int data) {
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
