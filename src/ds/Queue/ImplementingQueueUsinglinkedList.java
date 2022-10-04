package ds.Queue;

public class ImplementingQueueUsinglinkedList {
    Node head = null;
    Node tail = null;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {
        ImplementingQueueUsinglinkedList QueuesUsingLL = new ImplementingQueueUsinglinkedList();
        QueuesUsingLL.enQueue(10);
        QueuesUsingLL.enQueue(20);
        QueuesUsingLL.enQueue(30);
        QueuesUsingLL.enQueue(40);
        QueuesUsingLL.enQueue(50);
        QueuesUsingLL.displayQueue();
        System.out.println("Dequeued Item :"+QueuesUsingLL.deQueue());
        System.out.println("Dequeued Item :"+QueuesUsingLL.deQueue());
        System.out.println("Dequeued Item :"+QueuesUsingLL.deQueue());
        QueuesUsingLL.displayQueue();
        QueuesUsingLL.enQueue(70);
        QueuesUsingLL.displayQueue();

    }

    private int deQueue() {

        Node temp;
        if(head==null && tail ==null)
        {
            System.out.println("Queue is Empty");
            return 0;
        }
        else{
             temp= head;
            head= head.next;
            temp.next=null;
        }

        return temp.data;
    }

    private void displayQueue() {
        if (head != null) {
            Node currNode = head;
            System.out.print("LinkedList: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        }
        System.out.println();
    }

    private void enQueue(int item) {
        Node new_node = new Node(item);
        if (head == null && tail == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
    }
}
