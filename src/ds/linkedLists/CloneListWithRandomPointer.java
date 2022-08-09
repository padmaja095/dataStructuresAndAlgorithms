package ds.linkedLists;

import java.util.HashMap;

//Q: the given DLL has prev and next pointer,as usual next points to next elements in the list. but the prev pointer points to the random elemts in the list.
// the task is to clone the list into another list. with normal DLL this can be done easily. it gets complicated beacuse of prev - randomly points to another node.
//approach 1: step 1: create a nodes  as like original ones with only next pointers. step 2: in hashset, copy the node as key from original list and value as address of the elements in the new list.
// with hashmap we can then point all the previous nodes.
//approach 2: creating a dummy node aslike original elemnets. and connect it to next to original elements.
//For eg: [1]->1->[2]->2->[3]->3->[4]->4->[5]5->null. then by doing simple links manipulation we can achieve the same as like original for these dummy nodes.
// at that split these two another one as new list. 
public class CloneListWithRandomPointer {
    Node head;

    static class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String args[]) {
        /* Start with the empty list. */
        CloneListWithRandomPointer list = new CloneListWithRandomPointer();
        Node firstNode = insert_at_end(list, 1);
        Node secNode = insert_at_end(list, 2);
        Node thrdNode = insert_at_end(list, 3);
        Node fourthNode = insert_at_end(list, 4);
        Node fifthNode = insert_at_end(list, 5);
        Node sixthNode = insert_at_end(list, 6);
        firstNode.prev = thrdNode;
        secNode.prev = fourthNode;
        thrdNode.prev = firstNode;
        fourthNode.prev = thrdNode;
        fifthNode.prev = thrdNode;
        sixthNode.prev=secNode;
        // Print the LinkedList
        printList(list);
        cloneLinkedlistUsingHashMap(list);
        cloneLinkedlist(list);

    }
   //approach 2
    private static void cloneLinkedlist(CloneListWithRandomPointer list) {
        Node headNode=list.head;
        // adding dummy nodes and conecting them to original ones
        while(headNode!=null)
        {
            Node temp=headNode;
            Node new_node= new Node(temp.data);
            new_node.next=temp.next;
            temp.next=new_node;
            headNode=headNode.next.next;
        }
        //connecting dummy's prev nodes as same like original ones
        headNode=list.head;
        while(headNode!=null)
        {
            headNode.next.prev=headNode.prev.next;
            headNode=headNode.next.next;
        }
        // spliting the orginal and the new cloned output list
        headNode=list.head;
        Node secListptr=headNode.next;
        while(headNode!=null)
        {
            headNode.next=headNode.next.next;
            headNode.next.next=headNode.next.next.next;
             headNode=headNode.next.next;
        }
        printList(list);
        printListForPointer(secListptr);
    }

    // approach 1:
    private static void cloneLinkedlistUsingHashMap(CloneListWithRandomPointer list) {
        Node node = list.head;
        Node secondListLast = null;
        Node secondListHead = null;
        while (node != null) {
            Node new_node = new Node(node.data);
            if (secondListHead == null) {
                secondListHead = new_node;
                secondListLast = new_node;
            } else {
                secondListLast.next = new_node;
                secondListLast = new_node;
            }
            node = node.next;
        }
        Node temp1 = list.head;
        HashMap<Integer, Integer> prevDataMap = new HashMap<>();
        Node temp2 = secondListHead;
        HashMap<Integer, Node> newListAddressMap = new HashMap<>();
        while (temp1 != null) {
            prevDataMap.put(temp1.data, temp1.prev.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            newListAddressMap.put(temp2.data, temp2);
            temp2 = temp2.next;
        }
        temp2 = secondListHead;
        while (temp2 != null) {
            if (prevDataMap.containsKey(temp2.data)) {
                temp2.prev = newListAddressMap.get(prevDataMap.get(temp2.data));
            }
            temp2 = temp2.next;
        }
        System.out.println("##########################");
        printListForPointer(secondListHead);

    }

    private static void printListForPointer(Node list) {
        if (list != null) {
            Node currNode = list;
            Node pre = list;
            System.out.print("LinkedList: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                pre = currNode;
                currNode = currNode.next;
            }
            System.out.print("From last Using Prev pointer LinkedList: ");
            for (int i = 0; i < 5; i++) {
                System.out.print(pre.data + " ");
                pre = pre.prev;

            }
        }
    }

    private static void printList(CloneListWithRandomPointer list) {
        if (list.head != null) {
            Node currNode = list.head;
            Node pre = list.head;
            System.out.print("LinkedList: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                pre = currNode;
                currNode = currNode.next;
            }
            System.out.print("From last Using Prev pointer LinkedList: ");
            for (int i = 0; i < 5; i++) {
                System.out.print(pre.data + " ");
                pre = pre.prev;

            }
        }
    }

    private static Node insert_at_end(CloneListWithRandomPointer list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node currNode = list.head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = new_node;
            new_node.prev = currNode;
        }
        return new_node;
    }
}
