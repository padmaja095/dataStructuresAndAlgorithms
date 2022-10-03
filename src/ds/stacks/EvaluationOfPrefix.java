package ds.stacks;

import java.util.Stack;

public class EvaluationOfPrefix {
    // same like evaluationofpostfix, but start from Righ to Left . instead of the other way.
    //example expr: +2**346
    public static void main(String args[])
    {
        String expr = "+2**346";
        int res = evaluationOfPrefix(expr);
        System.out.println(res);
    }

    private static int evaluationOfPrefix(String expr) {
        Stack<Integer> stack = new Stack<Integer>();
        int res=-1;
        for (int i = expr.length()-1 ; i >= 0; i--) {
            int x = Character.getNumericValue(expr.charAt(i));
            if (x>=0  && x<=9) {
                stack.push(x);
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (expr.charAt(i)) {
                    case '+':
                        res = a + b;
                        break;
                    case '-':
                        res = a - b;
                        break;
                    case '*':
                        res = a * b;
                        break;
                    case '/':
                        res = a / b;
                        break;
                }
                stack.push(res);                
            }
        }
        return stack.pop();
    }
}
