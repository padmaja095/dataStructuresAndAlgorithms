package ds.linkedLists;

public class ReverseLinkedlistFromMtoNNodes {
     Node head;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;

        }
    }
    public static void main(String args[]) {
        ReverseLinkedlistFromMtoNNodes reverseAlternativeKNodes = new ReverseLinkedlistFromMtoNNodes();
        insert_at_end(reverseAlternativeKNodes, 1);
        insert_at_end(reverseAlternativeKNodes, 2);
        insert_at_end(reverseAlternativeKNodes, 3);
        insert_at_end(reverseAlternativeKNodes, 4);
        insert_at_end(reverseAlternativeKNodes, 5);
        insert_at_end(reverseAlternativeKNodes, 6);
         
        reverseAlternativeKNodes.printList(reverseAlternativeKNodes.head);
         reverseAlternativeKNodes.reverseFromMtoNnode(reverseAlternativeKNodes.head, 3,5);
         reverseAlternativeKNodes.printList(reverseAlternativeKNodes.head);
    }
    private void reverseFromMtoNnode(Node head2, int m, int n) {

        
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

    public static Node insert_at_end(ReverseLinkedlistFromMtoNNodes list, int data) {
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
