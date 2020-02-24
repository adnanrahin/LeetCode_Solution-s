package score_of_parentheses_856;

public class Main {

    public static void main(String args[]) {

        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(()(()))"));

    }

    public static int scoreOfParentheses(String S) {

        int score = 0;
        int parenCounter = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                parenCounter++;
            else {
                parenCounter--;
                if (S.charAt(i - 1) == '(')
                    score += 1 << parenCounter;
            }
        }

        return score;
    }

}
