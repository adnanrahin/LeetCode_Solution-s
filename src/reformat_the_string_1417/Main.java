package reformat_the_string_1417;

import java.util.Stack;

public class Main {

    public static void main(String args[]) {

    }

    public String reformat(String s) {

        Stack<Character> letter = new Stack<>();
        Stack<Character> number = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) letter.push(s.charAt(i));
            if (Character.isDigit(s.charAt(i))) number.push(s.charAt(i));
        }

        if (Math.abs(letter.size() - number.size()) > 2) return "";

        StringBuilder reFormatString = new StringBuilder();

        if (letter.size() > number.size()) {
            while (!letter.isEmpty()) {
                reFormatString.append(letter.pop());
                if (!number.isEmpty()) reFormatString.append(number.pop());
            }
        } else {
            while (!number.isEmpty()) {
                reFormatString.append(number.pop());
                if (!letter.isEmpty()) reFormatString.append(letter.pop());
            }
        }

        return reFormatString.toString();
    }

}
