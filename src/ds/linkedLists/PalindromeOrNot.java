package ds.linkedLists;

import java.rmi.server.ServerNotActiveException;
import java.util.MissingFormatArgumentException;
import java.util.Stack;
import java.util.logging.SocketHandler;

public class PalindromeOrNot {
    //Q: in SLL find whether the elements in the list follow palindrome or not
    //approach 1: Use stack data structure to push the elements one by one 
    //.so now last element will be in the top and so on. now, 
    //again from first pop the elements from the stack and match it with current element. if both are equal then it is palindrome.
    // this takes O(n) times and O(n) space due to stack.
    //approach 2: With using any data structure, 
    //step 1: go to middle element using slow and fast pointer method.
    //step 2: two cases. the no of elements are odd or even. after the middle element reverse the second half and consider it as another list.
    //step 3: compare the two list of elements to find the palindrome . and atlast reverse back the list and attach it to the same list.
    // O(n) time and O(1) space
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static void main(String args[])
    {
        PalindromeOrNot palindromeOrNot = new PalindromeOrNot();
        insert_at_end(palindromeOrNot, 1);
        insert_at_end(palindromeOrNot, 2);
        insert_at_end(palindromeOrNot, 3);
        insert_at_end(palindromeOrNot, 4);
        insert_at_end(palindromeOrNot, 3);
        insert_at_end(palindromeOrNot, 2);
        insert_at_end(palindromeOrNot, 1);
        printList(palindromeOrNot);
        //palindromeOrNot.findPalindromeOrNotApproachOne(palindromeOrNot);
        palindromeOrNot.findPalindromeOrNotApproachTwo(palindromeOrNot);

    }
    //approach 2
    public void findPalindromeOrNotApproachTwo(PalindromeOrNot list) {
        if(list.head==null || list.head.next==null)
        {
            System.out.println("No elemnets present or onnly one lement is present. so it is not a palindrome");
        }
        else{
            Node fastPtr=list.head;
            Node slowPtr=list.head;
            Node previousToSlowPtr=list.head;
            Node midNode=list.head;
            //fast and slow poniter is used to find the midnode . the idea is that as fastptr is twice as fast as slowptr. when fast reached the end , the slow will reach the exact middle if the lements are odd.
            while(fastPtr!=null && fastPtr.next!=null)
            {
                fastPtr=fastPtr.next.next;
                previousToSlowPtr=slowPtr;
                slowPtr=slowPtr.next;

            }
            // when elements are odd. taking out the middle element KAYAK. taking out Y as. for reversing and comparing we need AK only. after that we will attach the Y .
            if(fastPtr!=null)
            {
                midNode=slowPtr;
                slowPtr=slowPtr.next;
            }
            previousToSlowPtr.next=null;
            Node secondhalf=reverse(slowPtr);
            compare(list.head,secondhalf);
            reverse(secondhalf);
           if(midNode!=null)
           {
            previousToSlowPtr.next=midNode;
            midNode.next=secondhalf;
           }
           else{
            previousToSlowPtr.next=secondhalf;
           }    
        }
    }
    private void compare(Node head, Node secondhalf) {
        while(head!=null && secondhalf!=null)
        {
            if(head.data==secondhalf.data)
            {
                head=head.next;
            secondhalf=secondhalf.next;
            }
            else{
                System.out.println("It is not a palindrome");
                return;
            }    
        }
        System.out.println("It is a palindrome");
    }
    private Node reverse(Node slowPtr) {
        Node prev=null;
        Node currentNode=slowPtr;
        Node next;
        while(currentNode!=null)
        {
            next=currentNode.next;
            currentNode.next=prev;
            prev=currentNode;
            currentNode=next;
        }
        return prev;
    }
    //approach 1 using stack
    public void findPalindromeOrNotApproachOne(PalindromeOrNot list)
    {
        Stack<Integer> palindromeStack= new Stack<>();
        Node currNode= list.head;
        while(currNode!=null)
        {
            palindromeStack.push(currNode.data);
            currNode=currNode.next;
        }
        currNode=list.head;
        while(currNode!=null)
        {
            if(currNode.data==palindromeStack.pop()){
                currNode=currNode.next;
            }
            else{
                System.out.println("It is not a palindrome");
                return;
            }
        }
        System.out.println("It is a palindrome");
    }
    public static PalindromeOrNot insert_at_end(PalindromeOrNot list, int data) {
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
    public static void printList(PalindromeOrNot list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList 
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
