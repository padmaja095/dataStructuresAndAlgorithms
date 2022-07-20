package ds.linkedLists;

//To implement a circular singly linked list, we take an external pointer that points to the last node of the list. If we have a pointer last pointing to the last node, then last -> next will point to the first node.
//The pointer last points to node Z and last -> next points to node P.
//Why have we taken a pointer that points to the last node instead of the first node? 
//For the insertion of a node at the beginning, we need to traverse the whole list. Also, for insertion at the end, the whole list has to be traversed. If instead of start pointer, we take a pointer to the last node, then in both cases there won’t be any need to traverse the whole list. So insertion at the beginning or at the end takes constant time, irrespective of the length of the list.
public class CircularSll {
    Node last; // points to last of list

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static CircularSll insert_at_begining(CircularSll list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        if (list.last == null) {
            list.last = new_node;
            new_node.next = new_node;
        } else {
            new_node.next = list.last.next;
            list.last.next = new_node;
        }
        return list;
    }

    // Method to insert a new node at the end
    public static CircularSll insert_at_end(CircularSll list, int data) {
        Node new_node = new Node(data);
        if (list.last == null) {
            list.last = new_node;
            new_node.next = new_node;
        } else {
            new_node.next = list.last.next;
            list.last.next = new_node;
            list.last = new_node;
        }
        return list;
    }

    // Method to insert a new node at the middle position with data
    public static CircularSll insert_in_the_middle(CircularSll list, int data, int positionData) {
        // To be inserted after the positioned data given.
        Node new_node = new Node(data);
        if (list.last == null) {
            list.last = new_node;
            new_node.next = new_node;
        } else {
            Node currNode = list.last.next;
            do {
                if (currNode.data == positionData) {
                    new_node.next = currNode.next;
                    currNode.next = new_node;
                    return list;
                }
                currNode = currNode.next;
            } while (currNode != list.last.next);
        }
        return list;
    }

    public static CircularSll delete_node(CircularSll list, int data) {
        Node currNode = list.last.next;
        Node prev = list.last;
        if (list.last == null) {
            System.out.println("Linked list is empty");
        } else if (list.last.data == data) {
            while (currNode != list.last) {
                prev = currNode;
                currNode = currNode.next;
            }
            prev.next = currNode.next;
            System.out.println(data + " found and deleted");
        } else {
            do {
                if (currNode.data == data) {
                    prev.next = currNode.next;
                    currNode.next = null;
                    return list;
                }
                prev = currNode;
                currNode = currNode.next;
            } while (currNode != list.last.next);
            System.out.println(data + " found and deleted");
        }
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(CircularSll list) {
        // Traverse through the LinkedList
        Node currNode = list.last.next;
        System.out.print("LinkedList: ");
        do {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        } while (currNode != list.last.next);
    }

    public static void count(CircularSll list) {
        Node currNode = list.last.next;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        int count = 0;
        do {
            count += 1;
            currNode = currNode.next;
        } while (currNode != list.last.next);
        System.out.println("Total Element is : " + count);
    }

    public static void main(String[] args) {
        /* Start with the empty list. */
        CircularSll list = new CircularSll();
        insert_at_begining(list, 1);
        insert_at_begining(list, 2);
        insert_at_begining(list, 3);
        insert_at_begining(list, 4);
        insert_at_end(list, 5);
        insert_at_end(list, 6);
        insert_at_end(list, 7);
        insert_at_end(list, 8);
        insert_in_the_middle(list, 10, 1);
        delete_node(list, 1);
        count(list);
        printList(list);
    }

}
