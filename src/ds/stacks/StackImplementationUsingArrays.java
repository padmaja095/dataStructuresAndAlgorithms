package ds.stacks;

public class StackImplementationUsingArrays {
    static class Stack {
        int arr[];
        int capacity;
        int top;

        Stack(int size) {
            this.arr = new int[size];
            this.capacity = size;
            this.top = -1;
        }
    }

    public static void main(String args[]) {
        StackImplementationUsingArrays stack = new StackImplementationUsingArrays();
        Stack s = new Stack(10);
        stack.push(s, 2);
        stack.push(s, 3);
        stack.push(s, 4);
        stack.push(s, 5);
        stack.push(s, 6);
        stack.push(s, 7);
        stack.push(s, 8);
        stack.push(s, 9);
        stack.push(s, 10);
        stack.push(s, 11);
        stack.push(s, 12);
        stack.printStack(s);
        System.out.println("Poped element "+stack.pop(s));
        stack.printStack(s);
    }

    private void push(Stack s, int ele) {
        if (!isStackFull(s)) {
            System.out.println("Inserting element in stack");
            s.arr[++s.top] = ele;
        } else {
            System.out.println("OverFlow\nProgram Terminated\n");
        }
    }

    private int pop(Stack s) {
        if (!isStackEmpty(s)) {
            return s.arr[s.top--];
        } else {
            System.out.println("STACK EMPTY");
            return s.top;
        }
    }

    private boolean isStackFull(Stack s) {
        if (s.arr.length == s.top + 1)
            return true;
        return false;
    }

    private boolean isStackEmpty(Stack s) {
        if (s.top == -1)
            return true;
        return false;
    }
    public void printStack(Stack s) {
        for (int i = 0; i <= s.top; i++) {
            System.out.print(s.arr[i] +" ");
        }
        System.out.println();
    }
}