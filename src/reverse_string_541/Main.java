package reverse_string_541;

public class Main {
    public static void main(String args[]) {

        System.out.println(reverseStr("abcdefg", 2));

    }

    public static String reverseStr(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        String solution = "";

        for (int i = 0; i < s.length(); i++) {
            if (stringBuilder.length() < k) {
                stringBuilder.insert(0, s.charAt(i));
            } else stringBuilder.append(s.charAt(i));

            if (stringBuilder.length() == 2 * k) {
                solution += stringBuilder;
                stringBuilder = new StringBuilder();
            }
        }

        if (stringBuilder.length() != 0) {
            solution += stringBuilder;
        }
        return solution;
    }

}
