package ds.linkedLists;

public class AlternatingSplitInSll {
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
        AlternatingSplitInSll alternatingSplitInSll = new AlternatingSplitInSll();
        insert_at_end(alternatingSplitInSll, 1);
        insert_at_end(alternatingSplitInSll, 2);
        insert_at_end(alternatingSplitInSll, 3);
        insert_at_end(alternatingSplitInSll, 4);
        insert_at_end(alternatingSplitInSll, 5);
        insert_at_end(alternatingSplitInSll, 6);
        insert_at_end(alternatingSplitInSll, 7);

        printList(alternatingSplitInSll);
        alternatingSplitInSll.SplitLinkedList(alternatingSplitInSll);

    }

    private  void SplitLinkedList(AlternatingSplitInSll alternatingSplitInSll) {
        Node currNode = alternatingSplitInSll.head;
        int counter = 0;
         Node lastPtrOfA=null;
         Node lastPtrOfB=null;
        AlternatingSplitInSll newListA = new AlternatingSplitInSll();
        AlternatingSplitInSll newListB = new AlternatingSplitInSll();
        while (currNode != null) {
            counter++;
            if (counter % 2 == 0) {
                lastPtrOfA=moveMethod(newListA, lastPtrOfA, currNode);
            }
            else {
                lastPtrOfB=  moveMethod(newListB, lastPtrOfB, currNode);
            }
            currNode = currNode.next;
        }
        printList(alternatingSplitInSll);
        printList(newListA);
        printList(newListB);
    }

    private Node moveMethod(AlternatingSplitInSll newList, Node lastPtr, Node currNode) {
        Node new_Node =  new Node(currNode.data);
        if (newList.head == null) {
            newList.head = new_Node;
            lastPtr = new_Node;
        } else {
            lastPtr.next = new_Node;
            lastPtr = new_Node;
        }
        return lastPtr;
    }

    public static Node insert_at_end(AlternatingSplitInSll list, int data) {
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

    public static void printList(AlternatingSplitInSll list) {
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
