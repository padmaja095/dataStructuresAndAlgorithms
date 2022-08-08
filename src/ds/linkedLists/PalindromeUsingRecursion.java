package ds.linkedLists;

public class PalindromeUsingRecursion {
	/*
	 * Node fastPtr; Node slowPtr; Node prevPtr; Node goRight;
	 */
	Node left;
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
        PalindromeUsingRecursion palindromeUsingRecursion = new PalindromeUsingRecursion();
        insert_at_end(palindromeUsingRecursion, 1);
        insert_at_end(palindromeUsingRecursion, 2);
        insert_at_end(palindromeUsingRecursion, 3);
        insert_at_end(palindromeUsingRecursion, 4);
        insert_at_end(palindromeUsingRecursion, 3);
        insert_at_end(palindromeUsingRecursion, 2);
        insert_at_end(palindromeUsingRecursion, 1);
        printList(palindromeUsingRecursion);
       
        boolean bool = palindromeUsingRecursion.findPalindromeOrNotUsingRecursion(palindromeUsingRecursion);
        System.out.println(bool);

    }
   
    private boolean findPalindromeOrNotUsingRecursion(PalindromeUsingRecursion list) {
    	//fastPtr=list.head;Node slowPtr=list.head;
        boolean result = isPalindromeUtil(head);
        return result;
    }


    
	boolean isPalindromeUtil(Node right) {
		/*
		 * if (fastPtr != null && fastPtr.next == null) { slowPtr = prevPtr; return
		 * true; } else if (fastPtr==null) { System.out.println(slowPtr.data +" : " +
		 * prevPtr.data+" : "+ goRight.data); goRight=slowPtr; slowPtr = prevPtr;
		 * System.out.println(slowPtr.data +" : " + prevPtr.data+" : "+ goRight.data);
		 * 
		 * return true;
		 * 
		 * } // prevPtr=slowPtr; fastPtr = fastPtr.next.next; prevPtr = slowPtr; slowPtr
		 * = slowPtr.next; goRight = slowPtr.next; boolean isp =
		 * isPalindromeUtil(prevPtr); if (isp == false) return false; if (fastPtr==null)
		 * { System.out.println("even"); System.out.println(goRight.data +" ("+goRight+
		 * ") ===========" + prevPtr.data +" ("+prevPtr); boolean isp1 = (goRight.data
		 * == prevPtr.data); goRight = goRight.next; return isp1;
		 * 
		 * } else if (fastPtr.next == null) { System.out.println(goRight.data + ":" +
		 * prevPtr.data); boolean isp1 = (goRight.data == prevPtr.data); goRight =
		 * goRight.next; return isp1; }
		 * 
		 * return false;
		 */		
		left = head;
		if (right == null)
			return true;
		boolean isp = isPalindromeUtil(right.next);
		if (isp == false)
			return false;
        boolean isp1 = (right.data == left.data);
        left = left.next;
        return isp1;
	}

    public static PalindromeUsingRecursion insert_at_end(PalindromeUsingRecursion list, int data) {
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

    public static void printList(PalindromeUsingRecursion list) {
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
