package ds.linkedLists;
public class CircularDll {
    Node last;

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }
    public static void main(String[] args) {
        /* Start with the empty list. */
        CircularDll list = new CircularDll();
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
    private static void count(CircularDll list) {
        int counter=0;
        Node currNode= list.last.next;
        do {
            currNode=currNode.next;
            counter++;
        }while(currNode!=list.last.next);
        System.out.println("No of elements present in the list is: " + counter);
    }
    private static void printList(CircularDll list) {
        Node currNode=list.last.next;// last.next - accessing the first element as it is CLL for printList
        System.out.print("LinkedList: ");
        do{
            System.out.print(currNode.data +" ");
            currNode=currNode.next;
        }
        while(currNode!=list.last.next);
    }
    private static void delete_node(CircularDll list, int deleteData) {
        if(list.last==null)
        {
            System.out.println("List is empty");
        }
        else if(list.last.data==deleteData)
        {
            Node firstNode=list.last.next;
            list.last.prev.next=firstNode;
            firstNode.prev=list.last.prev;
            list.last=list.last.prev;
        }
        else { 
              Node currNode= list.last.next;
            do{
                if(currNode.data==deleteData)
                {
                    Node temp=currNode.prev;
                    currNode.prev.next=currNode.next;
                    currNode.next.prev=temp;
                    return;
                }
                currNode=currNode.next;
            }while(currNode!=list.last.next);
        }
    }
    private static void insert_in_the_middle(CircularDll list, int data, int posData) {
    //after given posData
        Node new_node=new Node(data);
        Node currNode= list.last.next;
        do{
            if(currNode.data==posData)
            {
                new_node.prev=currNode;
                new_node.next=currNode.next;
                currNode.next=new_node;
                return;
            }
            currNode=currNode.next;
        }while(currNode!=list.last.next);
    }
    private static void insert_at_end(CircularDll list, int i) {
        Node new_node= new Node(i);
        if(list.last==null)
        {
            list.last=new_node;
            new_node.prev=new_node;
            new_node.next=new_node;
        }
        else{
           Node currLastNode= list.last;
           Node firstNode= list.last.next;
           
            firstNode.prev=new_node;
            new_node.next=firstNode;

            currLastNode.next=new_node;
            new_node.prev=currLastNode;
            list.last=new_node;
        }
    }
    private static void insert_at_begining(CircularDll list, int i) {
        Node new_node= new Node(i);
        if(list.last==null)
        {
            list.last=new_node;
            new_node.prev=new_node;
            new_node.next=new_node;
        }
        else{
            Node temp =list.last.next;
            list.last.next=new_node;
            new_node.prev=list.last;
            new_node.next=temp;
            temp.prev= new_node;
        }
    }
}