package evaluate_reverse_polish_natation_150;

import java.util.Stack;

public class Main {


    public static void main(String args[]) {

        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 2
    }

    public static int evalRPN(String[] tokens) {
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String str = tokens[i];

            if (str.equals("+") || str.equals("*") || str.equals("/") || str.equals("-")) {
                int a2 = stack.pop();
                int a1 = stack.pop();
                if (str.equals("+"))
                    stack.push(a1 + a2);
                else if (str.equals("-"))
                    stack.push(a1 - a2);
                else if (str.equals("*"))
                    stack.push(a1 * a2);
                else if (str.equals("/"))
                    stack.push(a1 / a2);
            } else stack.push(Integer.parseInt(str));

        }

        return stack.pop();
    }
}
