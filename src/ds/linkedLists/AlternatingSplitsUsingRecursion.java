package ds.linkedLists;

public class AlternatingSplitsUsingRecursion {
    
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static void main(String args[]) {
        AlternatingSplitsUsingRecursion alternatingSplitInSll = new AlternatingSplitsUsingRecursion();
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
    private  void SplitLinkedList(AlternatingSplitsUsingRecursion alternatingSplitInSll) {
        AlternatingSplitsUsingRecursion listA= new AlternatingSplitsUsingRecursion();
    AlternatingSplitsUsingRecursion listB= new AlternatingSplitsUsingRecursion();
        int counter=0;
        splitLLRecusrion(alternatingSplitInSll.head,counter,listA,listB);
        printList(listA);
        printList(listB);

    }
    private void splitLLRecusrion(Node currNode,int counter,AlternatingSplitsUsingRecursion listA,AlternatingSplitsUsingRecursion listB) {
        if(currNode==null){
            return;
        }
        else{
            counter++;
            splitLLRecusrion(currNode.next,counter,listA,listB);
            if (counter % 2 == 0) {
            moveMethod(listA, currNode);
            }
            else {
                 moveMethod(listB, currNode);
            }            
        }
    }
    private void moveMethod(AlternatingSplitsUsingRecursion newList, Node currNode) {
        Node new_Node =  new Node(currNode.data);
        if (newList.head == null) {
            newList.head = new_Node;
        } else {
            new_Node.next=newList.head;
            newList.head=new_Node;
        }
    }
    public static Node insert_at_end(AlternatingSplitsUsingRecursion list, int data) {
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
    public static void printList(AlternatingSplitsUsingRecursion list) {
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
