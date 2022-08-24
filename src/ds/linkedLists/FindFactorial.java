package ds.linkedLists;

public class FindFactorial {
    //Q: Find factorial of large number.
    //A: Done with array or linkedlist and print the same.
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data)
        {this.data=data;}
    }
    public static void main(String args[])
    {
        findFactorial(15);
    }
    private static void printlist(Node list) {
        if (list != null) {
            Node currNode = list;
            Node pre = list;
            System.out.print("LinkedList: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                pre = currNode;
                currNode = currNode.next;
            }
        }
    }
    private static void findFactorial(int fact) {
        Node res= new Node(1);
        Node hNode=res;
       int prod=1; int carry=0;int r;
        for(int i=2;i<=fact;i++)
        {
            Node prev=null;
            Node currNode=hNode;
            while(currNode!=null)
            {
                prod=carry+(i*currNode.data);
                carry=prod/10;
                r=prod%10;
                currNode.data=r;
                prev=currNode;
                currNode=currNode.next;
            }
            while(carry!=0)
            {
                int q=carry%10;
                Node new_node= new Node(q);
                prev.next=new_node;
                prev=new_node;
                carry=carry/10;
            }
        }
        //reversing the list so that it prints respectively
        Node curr= hNode;
        Node pre=null;
        Node next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        printlist(pre);
    }
}