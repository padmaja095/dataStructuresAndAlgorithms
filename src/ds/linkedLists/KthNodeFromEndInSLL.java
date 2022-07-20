package ds.linkedLists;

import ds.linkedLists.CircularSll.Node;

public class KthNodeFromEndInSLL {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Q: Given SLL,and K integer is less than size of SLL and greater than 0.find
    // the kth node from the end of the SLL.
    // approach 1: Traverse though the SLL and find n which is the size of
    // SLL.(n-k+1) from the beginning is the output node. time - O(n) - but needs
    // two traversal of SLL.
    // approach 2 : in One traversal. O(n) - have P and Q two pointers pointing at
    // the begining of the SLL. have pointer Q jump to Kth distance from begining.
    // and then increment both the pointer by one till the Q reaches the end of the
    // node i.e., null. then P is at (N-k+1) node. as we jumped Q to kth distance in
    // first time.
    public static void main(String args[]) {
        KthNodeFromEndInSLL kthNodeFromEndInSLL = new KthNodeFromEndInSLL();
        kthNodeFromEndInSLL.push(12);
        kthNodeFromEndInSLL.push(15);
        kthNodeFromEndInSLL.push(1);
        kthNodeFromEndInSLL.push(35);
        kthNodeFromEndInSLL.push(40);
        kthNodeFromEndInSLL.push(31);
        kthNodeFromEndInSLL.push(33);
        kthNodeFromEndInSLL.printList(kthNodeFromEndInSLL);
        kthNodeFromEndInSLL.findKthNodeFromEndInSLL(kthNodeFromEndInSLL, 8);
    }

    // approach 2
    private void findKthNodeFromEndInSLL(KthNodeFromEndInSLL list, int k) {
        Node p = list.head;
        Node q = list.head;
        for (int i = 0; i < k; i++) {
            if (q != null) {
            q = q.next;
            }
            else{
                System.out.println("K is larger than the size of SLL");
                return;
            }
        }
        while (q != null) {
            p = p.next;
            System.out.println(q.data);
                q = q.next;
        }
        System.out.println("The Kth Node is : " + p.data);
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList(KthNodeFromEndInSLL list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

}
