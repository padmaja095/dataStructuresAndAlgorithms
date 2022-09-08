package ds.linkedLists;

public class SwapKthAndKminus1thNodeInLikedlist {
    
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static SwapKthAndKminus1thNodeInLikedlist insert_at_end(SwapKthAndKminus1thNodeInLikedlist list, int data) {
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
        SwapKthAndKminus1thNodeInLikedlist swapKthAndKminus1thNodeInLikedlist = new SwapKthAndKminus1thNodeInLikedlist();
        insert_at_end(swapKthAndKminus1thNodeInLikedlist, 1);
        insert_at_end(swapKthAndKminus1thNodeInLikedlist, 2);
        insert_at_end(swapKthAndKminus1thNodeInLikedlist, 3);
        insert_at_end(swapKthAndKminus1thNodeInLikedlist, 4);
        insert_at_end(swapKthAndKminus1thNodeInLikedlist, 5);
        printList(swapKthAndKminus1thNodeInLikedlist);
        swapKthAndKminus1thNodeInLikedlist.swapKthAndKminus1thElement(swapKthAndKminus1thNodeInLikedlist,3);
        printList(swapKthAndKminus1thNodeInLikedlist);
    }
    public static void printList(SwapKthAndKminus1thNodeInLikedlist list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    private void swapKthAndKminus1thElement(SwapKthAndKminus1thNodeInLikedlist swapKthAndKminus1thNodeInLikedlist,int k) {
        Node p=swapKthAndKminus1thNodeInLikedlist.head;
        Node q= swapKthAndKminus1thNodeInLikedlist.head;
        if(k<0)
        {return;}
        for(int i=0;i<k;i++)
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
           System.out.println("Cant Process as given K is incorrect , no element is present in (k-1)");
            return;
        }
        while(q.next!=null)
        {
            p=p.next;
            q=q.next;
        }
        int temp=p.data;
        p.data=p.next.data;
        p.next.data=temp;
    }
    
}
