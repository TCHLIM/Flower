package consoleapps;

import java.util.Stack;

/**
 *
 * @author Samuel Wong Kim Foong 18WMR12048
 */
public class BalanceCheckerDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String expr = "{([])}";
        System.out.println(expr + " is " + (checkBalance(expr) ? "balanced!" : "not balanced."));
    }

    // Static method to check whether the expression is balanced
    public static boolean checkBalance(String expression) {
        Stack<Character> exprStack = new Stack<>();
        boolean isBalanced = true;
        char nextCharacter = ' ';

        // Loop through the exprStack
        for (int i = 0; isBalanced && i < expression.length(); i++) {
            nextCharacter = expression.charAt(i);

            switch (nextCharacter) {
                case '(':
                case '[':
                case '{':
                    exprStack.push(nextCharacter);
                    break;
                case ')':
                case ']':
                case '}':
                    // If stack is empty, no need to check ady
                    // it is already unbalanced.
                    if (exprStack.isEmpty()) {
                        isBalanced = false;
                    } else {
                        char openDelimeter = exprStack.pop();
                        isBalanced = isPaired(openDelimeter, nextCharacter);
                    }
                    break;
            }
        }

        if (!exprStack.isEmpty()) {
            isBalanced = false;
        }

        return isBalanced;
    }

    // Public static method to check whether the delimeter is paired or not
    public static boolean isPaired(char open, char close) {
        // Conditional checking
        if ((open == '{' && close == '}')
                || (open == '[' && close == ']')
                || (open == '(' && close == ')')) {
            return true;
        }

        return false;
    }
}
