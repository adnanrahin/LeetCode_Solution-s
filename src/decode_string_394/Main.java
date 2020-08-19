package decode_string_394;

import java.util.Stack;

public class Main {

    public static String decodeString(String s) {

        String str = "";
        Stack<String> strings = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            if (Character.isLetter(s.charAt(i))) {
                str += s.charAt(i);
            } else if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                strings.push(str);
                numbers.push(num);
                num = 0;
                str = "";
            } else {
                int rpt = numbers.pop();
                String rptString = (strings.isEmpty()) ? "" : strings.pop();
                for (int j = 0; j < rpt; j++) {
                    rptString += str;
                }
                str = rptString;
            }
        }
        return str;
    }

}
