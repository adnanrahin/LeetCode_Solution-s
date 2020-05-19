package remove_all_adjacent_duplicates_in_string_1047;

import java.util.Stack;

public class Main {

    public static void main(String args[]) {

        System.out.println(removeDuplicates(""));

    }

    public static String removeDuplicates(String S) {
        String solution = new String();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if (stack.isEmpty()) {
                stack.add(temp);
            } else if (stack.peek() == temp) {
                stack.pop();
            }else if(stack.peek() != temp)
                stack.add(temp);
        }

        for (Character ch : stack)
            solution += ch;

        return solution;
    }

}
