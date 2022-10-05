package ds.linkedLists;
public class RotateListKTimes {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String args[]) {
        RotateListKTimes list = new RotateListKTimes();
        insert_at_end(list, 1);
        insert_at_end(list, 2);
        insert_at_end(list, 3);
        insert_at_end(list, 4);
        insert_at_end(list, 5);
        insert_at_end(list, 6);
        insert_at_end(list, 7);
        printList(list);
        Node res = list.rotateListKtimes(list, 2);
        printList(res);
    }
    private Node rotateListKtimes(RotateListKTimes list, int k) {
        int count = 0;
        Node currNode = list.head;
        while (currNode.next != null) {
            count++;
            currNode = currNode.next;
        }
        k = count + 1 - k;
        Node q = list.head;
        Node r = null;
        while (k-- != 0) {
            r = q;
            q = q.next;
        }
        currNode.next = list.head;
        r.next = null;
        return q;
    }
    public static void printList(RotateListKTimes list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    public static void printList(Node currNode) {
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    public static RotateListKTimes insert_at_end(RotateListKTimes list, int data) {
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
}
