package ds.linkedLists;

public class FindUnionAndIntersection {
    // Q: Given two linked list S1: 6->4->2->8->10-> S2: 2->1->3->4
    // union list is : 6->4->2->8->10->1->3 and intersection-list is: 2->4
    // Approach 1:Using Sorting: Sort S1 and S2.have a pointer on head of S1 and
    // S2,has the list is sorted compare the lists,
    // for union : insert the smaller number first and and increment. if the nums
    // are equal insert the number and increment bith. incase of one list ends,chcek
    // for the other list for inserting.
    // for intersection: if both are equal then, insert increment if onelist end ,
    // come out of the loop.
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
        FindUnionAndIntersection fui = new FindUnionAndIntersection();
        // S1: 6->4->2->8->10-> S2: 2->1->3->4
        Node S1head = new Node(6);
        S1head.next = new Node(4);
        S1head.next.next = new Node(2);
        S1head.next.next.next = new Node(8);
        S1head.next.next.next.next = new Node(10);
        Node S2head = new Node(2);
        S2head.next = new Node(1);
        S2head.next.next = new Node(3);
        S2head.next.next.next = new Node(4);
        fui.findUnionIntersection(S1head, S2head);
    }

    private Node unionPtrManipulation(FindUnionAndIntersection unionList, Node new_node, Node unionPtr) {
        if (unionList.head == null) {
            unionList.head = new_node;
            unionPtr = new_node;
        } else {
            unionPtr.next = new_node;
            unionPtr = new_node;
        }
        return unionPtr;
    }

    private void findUnionIntersection(Node s1head, Node s2head) {
        FindUnionAndIntersection unionList = new FindUnionAndIntersection();
        FindUnionAndIntersection intersectionList = new FindUnionAndIntersection();
        s1head = mergeSort(s1head);
        s2head = mergeSort(s2head);
        Node s1ptr = s1head;
        Node s2ptr = s2head;
        Node unionPtr = null; 
        Node intersectionPtr=null;
        while (s1ptr != null && s2ptr != null) {
            if (s1ptr.data > s2ptr.data) {
                Node new_node = new Node(s2ptr.data);
                unionPtr = unionPtrManipulation(unionList, new_node, unionPtr);
                s2ptr = s2ptr.next;
            } else {
                Node new_node = new Node(s1ptr.data);
                unionPtr = unionPtrManipulation(unionList, new_node, unionPtr);
                if (s1ptr.data == s2ptr.data) {
                    Node node = new Node(s1ptr.data);
                    if(intersectionList.head==null)
                    {
                        intersectionList.head = node;
                        intersectionPtr=node;
                    }
                    else{
                        intersectionPtr.next=node;
                        intersectionPtr=node;
                    }
                    s1ptr = s1ptr.next;
                    s2ptr = s2ptr.next;
                } else {
                    s1ptr = s1ptr.next;
                }
            }
        }
        if (s1ptr != null) {
            while (s1ptr != null) {
                Node new_node = new Node(s1ptr.data);
                unionPtr.next = new_node;
                unionPtr = new_node;
                s1ptr = s1ptr.next;
            }
        } else {
            while (s2ptr != null) {
                Node new_node = new Node(s2ptr.data);
                unionPtr.next = new_node;
                unionPtr = new_node;
                s2ptr = s2ptr.next;
            }
        }
        printList(unionList);
        printList(intersectionList);
      

    }

    private Node mergeSort(Node headNode) {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }
        Node middle = getMiddleNode(headNode);
        Node middleNext = middle.next;
        middle.next = null;
        Node left = mergeSort(headNode);
        Node right = mergeSort(middleNext);
        Node sortedNode = mergeTwoSortedLinkedlistUsingRecursion(left, right);
        return sortedNode;
    }

    private Node getMiddleNode(Node headNode) {
        if (headNode == null)
            return headNode;
        Node tortoise = headNode;
        Node hare = headNode;
        while (hare.next != null && hare.next.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return tortoise;
    }

    private static Node mergeTwoSortedLinkedlistUsingRecursion(Node listHead1, Node listHead2) {
        if (listHead1 == null) {
            return listHead2;
        } else if (listHead2 == null) {
            return listHead1;
        }
        if (listHead1.data > listHead2.data) {
            listHead2.next = mergeTwoSortedLinkedlistUsingRecursion(listHead1, listHead2.next);
            return listHead2;
        } else {
            listHead1.next = mergeTwoSortedLinkedlistUsingRecursion(listHead1.next, listHead2);
            return listHead1;
        }
    }

    public static void printList(FindUnionAndIntersection list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    public static void printList(Node list) {
        Node currNode = list;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
