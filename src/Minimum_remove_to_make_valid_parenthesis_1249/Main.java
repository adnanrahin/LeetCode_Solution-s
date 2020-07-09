package Minimum_remove_to_make_valid_parenthesis_1249;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(minRemoveToMakeValid(""));
        System.out.println(minRemoveToMakeValid("((((()))"));

    }

    public static String minRemoveToMakeValid(String s) {

        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) sb.append(s.charAt(i));
            else if (s.charAt(i) == '(') {
                stack.add(sb.length());
                sb.append('(');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) continue;
                else {
                    sb.append(s.charAt(i));
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }

}
