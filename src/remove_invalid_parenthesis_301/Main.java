package remove_invalid_parenthesis_301;

import java.util.*;

public class Main {
    public static void main(String args[]) {

        boolean found = false;

        System.out.println(false);

        System.out.println(removeInvalidParentheses("lee(t(c)o)de)"));
        System.out.println(removeInvalidParentheses(")(f"));

    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> solution = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            String parent = queue.poll();
            if (visited.contains(parent)) continue;
            visited.add(parent);
            if (isValidParenthesis(parent)) {
                solution.add(parent);
            }
            if (solution.size() != 0) continue;
            for (int i = 0; i < parent.length(); i++) {
                if (parent.charAt(i) == '(' || parent.charAt(i) == ')') {
                    String children = parent.substring(0, i) + parent.substring(i + 1, parent.length());
                    queue.add(children);
                }
            }
        }

        return solution;
    }

    public static boolean isValidParenthesis(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                counter++;
            else if (str.charAt(i) == ')')
                counter--;
            if (counter < 0) return false;
        }
        return counter == 0;
    }

}
