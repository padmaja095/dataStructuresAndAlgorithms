package ds.stacks;
import java.util.Stack;
public class InfixToPostfix {
    public static void main(String args[]) {
        StringBuffer expression= new StringBuffer();
        expression.append("(2*3+4*(5-6))");
        //String expression = "(2*3+4*(5-6))";
        StringBuffer str=infixToPostfix(expression);
        System.out.println(str);
    }
    private static int priority(Character c) {
        if (c == '(') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }
    public static StringBuffer infixToPostfix(StringBuffer expr) {
        Stack<Character> stack = new Stack<Character>();
        Character pop;StringBuffer output= new StringBuffer();
        for (int i = 0; i < expr.length(); i++) {
            Character x = expr.charAt(i);
            if (Character.isLetterOrDigit(x)) {
                output.append(x);
            } else if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                while ((pop = stack.pop()) != '(') {
                    output.append(pop);
                }
            } else {
                if (!stack.empty() && priority(stack.peek()) >= priority(x)) {
                    output.append(stack.pop());
                }
                stack.push(x);
            }
        }
        while (!stack.empty()) {
            output.append(stack.pop());
        }
        return output;
    }
}