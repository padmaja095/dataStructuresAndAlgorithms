package ds.linkedLists;
public class RemoveNthNodeFromEndOfLinkedlist {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static RemoveNthNodeFromEndOfLinkedlist insert_at_end(RemoveNthNodeFromEndOfLinkedlist list, int data) {
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
        RemoveNthNodeFromEndOfLinkedlist removeNthNodeFromEndOfLinkedlist = new RemoveNthNodeFromEndOfLinkedlist();
        insert_at_end(removeNthNodeFromEndOfLinkedlist, 1);
        insert_at_end(removeNthNodeFromEndOfLinkedlist, 2);
        insert_at_end(removeNthNodeFromEndOfLinkedlist, 3);
        insert_at_end(removeNthNodeFromEndOfLinkedlist, 4);
        insert_at_end(removeNthNodeFromEndOfLinkedlist, 5);
        printList(removeNthNodeFromEndOfLinkedlist);
        removeNthNodeFromEndOfLinkedlist.removeNthNode(removeNthNodeFromEndOfLinkedlist,4);
        printList(removeNthNodeFromEndOfLinkedlist);
    }
    public static void printList(RemoveNthNodeFromEndOfLinkedlist list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    private void removeNthNode(RemoveNthNodeFromEndOfLinkedlist removeNthNodeFromEndOfLinkedlist,int n) {
        Node p=removeNthNodeFromEndOfLinkedlist.head;
        Node q= removeNthNodeFromEndOfLinkedlist.head;
        
        for(int i=0;i<n;i++)
        {
            if (q != null) {
            q = q.next;
            }
            else{
                System.out.println("N is larger than size of the linked list.");
                return;
            }
        }
        if(q==null)
        {
            removeNthNodeFromEndOfLinkedlist.head=removeNthNodeFromEndOfLinkedlist.head.next;
            return;

        }
        while(q.next!=null)
        {
            p=p.next;
            q=q.next;
        }
        p.next=p.next.next;
        

    }
    
}
