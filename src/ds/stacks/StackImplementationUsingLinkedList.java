package ds.stacks;
public class StackImplementationUsingLinkedList {
    Node top;
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String args[]) {
        StackImplementationUsingLinkedList stack = new StackImplementationUsingLinkedList();
        push(1, stack);
        push(2, stack);
        push(3, stack);
        printLinkedlist(stack);
        pop(stack);
        printLinkedlist(stack);
        pop(stack);
        printLinkedlist(stack);
        pop(stack);
        printLinkedlist(stack);
        pop(stack);
        printLinkedlist(stack);
    }
    private static void pop(StackImplementationUsingLinkedList stack) {
        if (stack.top == null) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("poping the element " + stack.top.data);
            stack.top = stack.top.next;
        }
    }
    private static void push(int i, StackImplementationUsingLinkedList stack) {
        Node new_node = new Node(i);
        if (stack.top == null) {
            stack.top = new_node;
        } else {
            new_node.next = stack.top;
            stack.top = new_node;
        }
    }
    private static void printLinkedlist(StackImplementationUsingLinkedList stack) {
        Node temp = stack.top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}