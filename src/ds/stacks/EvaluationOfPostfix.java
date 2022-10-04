package ds.stacks;

import java.util.Stack;

import javax.swing.Popup;

public class EvaluationOfPostfix {
    // GIven expression convert it from infix to postfix.
    // Read each elemnet if it is operand, push it to stack.
    // if it is operator, pop the last two element and perform the calc. with
    // current operator. and push the result to stack
    // once expression is fully evaluated, pop the element from stack. that is the
    // result.
    public static void main(String args[]) {
        String expr = "234*6*+"; 
        int res = evaluationOfPostfix(expr);
        System.out.println(res);
    }
    private static int evaluationOfPostfix(String expr) {
        Stack<Integer> stack = new Stack<Integer>();
        int res=-1;
        for (int i = 0; i < expr.length(); i++) {
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
