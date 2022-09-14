package ds.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParanthesisCheck {
    public static void main(String args[])
    {
        String str="{()[()]}";
       if(isParanthesisBalanced(str))
        System.out.println("Balanced");
       else
        System.out.println("Not Balanced");

    }

    private static boolean isParanthesisBalanced(String str) {
       // Stack<Character> stack= new Stack<Character>();
       //Using ArrayDeque is faster than using Stack class
       Deque<Character> stack = new ArrayDeque<Character>();
       for(int i=0;i<str.length();i++)
       {
        char x=str.charAt(i);
        if(x=='(' || x=='{' || x=='[')
        { 
            stack.push(x);
        }
        if(stack.isEmpty())
        {
            return false;
        }
        char check;
        switch(x){
            case ')':
                check=stack.pop();
                if(check=='}' || check==']')
                    return false;
                break;  
            case '}':
                check=stack.pop();
                if(check==')' || check==']')
                    return false;
                break;  
            case ']':
                check=stack.pop();
                if(check=='}' || check==')')
                    return false;
                break;
        }
       }
       return (stack.isEmpty());
    }
}
