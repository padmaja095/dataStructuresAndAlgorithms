package ds.linkedLists;

public class FindNextGreaterNode {
    // Key is that, Travel from the last node to first node will easily solve the
    // problem.
    // In DLL, traversing backward is easy.
    // In case of SLL- reverse the input array. call the logic. the reverse both the
    // input array and output array.
    // we will use use DLL here.
    Node head;

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String args[]) {
        FindNextGreaterNode list = new FindNextGreaterNode();
        insert_at_begining(list, 5);
        insert_at_begining(list, 3);
        insert_at_begining(list, 4);
        insert_at_begining(list, 7);
        insert_at_begining(list, 2);
        printList(list.head);
        Node outputList = list.findNextGreaterNode(list);
        printList(outputList);

    }
    private static void insert_at_begining(FindNextGreaterNode list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;

        } else {
            new_node.next = list.head;
            new_node.next.prev = new_node;
            list.head = new_node;
        }
    }
    private static void printList(Node list) {
        if (list != null) {
            Node currNode = list;
            System.out.print("LinkedList: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        }
    }
    private Node findNextGreaterNode(FindNextGreaterNode list) {
        FindNextGreaterNode ouputList = new FindNextGreaterNode();
        Node new_node = list.head;
        while (new_node.next.next != null) {
            new_node = new_node.next;
        }
        Node node = new Node(0);
        ouputList.head = node;
        Node pointer = ouputList.head;
        int high = new_node.next.data;
        Node previous = ouputList.head;
        Node newNode = null;
        while (new_node != null) {
            if (high < new_node.data) {
                high = new_node.data;
            }
            if (high == new_node.data) {
                newNode = new Node(0);
            } else {
                newNode = new Node(high);
            }
            pointer.prev = newNode;
            newNode.next = previous;
            pointer = newNode;
            previous = newNode;
            new_node = new_node.prev;
        }
        return newNode;
    }
}