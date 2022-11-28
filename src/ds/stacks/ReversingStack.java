package ds.stacks;

import java.util.Stack;

import javax.annotation.processing.SupportedSourceVersion;

public class ReversingStack {
    //approach 1: using a call stack itself by recursion but it takes O(n^2) times and O(n) space
    //approach 2: using additional stack explicitly, that makes O(n) times and O(n) space
    public static void main(String args[])
    {
        Stack<Integer> stack= new Stack<>();
        stack.push(14);
        stack.push(9);
        stack.push(67);
        stack.push(91);
        stack.push(101);
        stack.push(25);
        int i=20;
        System.out.println(stack);
        System.out.println(i);
        reverseStackApproach1(stack,i);
        System.out.println(i);
        System.out.println(stack);

    }

    private static void reverseStackApproach1(Stack<Integer> stack,int i) {
        if(!stack.isEmpty())
        {
            int val= stack.pop();
            int j=10;
            i=j;
            System.out.println("inside"+i);
            reverseStackApproach1(stack,i);
            insertval(stack,val);
        }
    }

    private static void insertval(Stack<Integer> stack, int val) {
        if(stack.isEmpty())
        {
            stack.push(val);
        }
        else{
            int y= stack.pop();
            insertval(stack, val);
            stack.push(y);
        }
    }
    
}
