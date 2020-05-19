package maximum_score_after_splitting_a_string_1423;

public class Main {
    public static void main(String args[]) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00"));
    }

    public static int maxScore(String s) {
        int result = 0;
        int onex = 0;
        int zero = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') onex++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') zero++;
            if (s.charAt(i) == '1') onex--;
            result = Math.max(result, zero + onex);
        }

        return result;
    }

}
