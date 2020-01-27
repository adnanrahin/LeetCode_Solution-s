package minimum_add_to_make_parentheses_valid_921;

import java.util.Stack;

public class Main {

    public static void main(String args[]) {

    }

    public static int minAddToMakeValid(String S) {

        int minimumNumberOfParenthesis = 0;

        Stack<Character> stack = new Stack<>();

        int counter = 0;

        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == '(') {
                stack.push('(');
            } else if (S.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            } else
                minimumNumberOfParenthesis++;

        }

        return minimumNumberOfParenthesis + stack.size();

    }

}
