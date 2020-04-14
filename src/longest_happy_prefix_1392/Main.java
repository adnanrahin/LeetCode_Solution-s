package longest_happy_prefix_1392;

public class Main {

    public static void main(String args[]) {

        System.out.println(longestPrefix("a"));

    }

    public static String longestPrefix(String s) {

        int[] pi = new int[s.length()];
        int i = 0;
        int j = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else if (s.charAt(i) != s.charAt(j) && i > 0) {
                i = pi[i - 1];
            } else if (s.charAt(i) != s.charAt(j)) {
                pi[j] = 0;
                j++;
            }
        }
        return s.substring(0, pi[pi.length - 1]);
    }

}
