package goal_parese_interpretation_1678;

public class Main {

    public static void main(String[] args) {

    }

    public static String interpret(String command) {

        if (command.length() == 0) return "";

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i < command.length()) {
            if (command.charAt(i) == 'G') sb.append('G');
            else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i++;
                }
            } else if (command.charAt(i) == 'a') {
                if (command.charAt(i + 1) == 'l') {
                    sb.append("al");
                    i++;
                }
            }
            i++;
        }

        return sb.toString();
    }

}
