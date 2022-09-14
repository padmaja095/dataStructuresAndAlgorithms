package ds.stacks;

import java.nio.ReadOnlyBufferException;

public class InfixToPrefix {
    public static void main(String args[])
    {
        InfixToPostfix infixToPostfix= new InfixToPostfix();
        StringBuffer expr= new StringBuffer();
        expr.append("(2+(3*4)*6)");
        expr=reverseExpression(expr);
        System.out.println(expr);
        expr=infixToPostfix.infixToPostfix(expr);
        System.out.println(expr);
        expr=reverseExpression(expr);
         System.out.println(expr);
    }

    private static StringBuffer reverseExpression(StringBuffer expr) {
        StringBuffer rev_str=new StringBuffer();
        for(int i=expr.length()-1;i>=0;i--)
        {
            if(expr.charAt(i)=='(')
            {
                rev_str.append(')');
            }
            else if(expr.charAt(i)==')')
            {
                rev_str.append('(');
            }
            else{
                rev_str.append(expr.charAt(i));
            }            
        }
    return rev_str;
    }
    
}
