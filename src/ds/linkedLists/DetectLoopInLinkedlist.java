package ds.linkedLists;
public class DetectLoopInLinkedlist {
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
        DetectLoopInLinkedlist detectLoopInLinkedlist = new DetectLoopInLinkedlist();
        detectLoopInLinkedlist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        detectLoopInLinkedlist.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        int i = 1;
        while (i <= 4) {
            System.out.print(detectLoopInLinkedlist.head.data + " ");
            detectLoopInLinkedlist.head = detectLoopInLinkedlist.head.next;
            i++;
        }
        detectLoopInLinkedlist.detectloop(detectLoopInLinkedlist);
    }

    private void detectloop(DetectLoopInLinkedlist detectLoopInLinkedlist) {
       Node hare= detectLoopInLinkedlist.head;
       Node tortoise= detectLoopInLinkedlist.head;
       do{
        if(hare==null || tortoise==null || hare.next==null)
        {
            System.out.println("No loop Found in the list");
            return;
        }
         hare=hare.next.next;
         tortoise=tortoise.next;
       }while(hare.data!=tortoise.data);
       System.out.println("Loop Found in the List");
    }
}
