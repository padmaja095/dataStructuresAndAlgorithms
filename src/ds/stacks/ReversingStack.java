package ds.stacks;

import java.util.Stack;

public class ReversingStack {
    // approach 1: using a call stack itself by recursion but it takes O(n^2) times
    // and O(n) space
    // approach 2: using additional stack explicitly, that makes O(n) times and O(n)
    // space
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(14);
        stack.push(9);
        stack.push(67);
        stack.push(91);
        stack.push(101);
        stack.push(25);
        System.out.println(stack);
        // reverseStackApproach1(stack);
        Stack<Integer> outputStack = new Stack<>();
        outputStack = reverseStackApproach2(stack, outputStack);
        System.out.println(outputStack);
    }

    private static Stack<Integer> reverseStackApproach2(Stack<Integer> stack, Stack<Integer> outputStack) {
        if (stack.isEmpty()) {
            return outputStack;
        }
        outputStack.push(stack.pop());
        return reverseStackApproach2(stack, outputStack);
    }

    private static void reverseStackApproach1(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int val = stack.pop();
            reverseStackApproach1(stack);
            insertval(stack, val);
        }
    }

    private static void insertval(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
        } else {
            int y = stack.pop();
            insertval(stack, val);
            stack.push(y);
        }
    }
}
