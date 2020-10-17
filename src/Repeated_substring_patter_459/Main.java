package Repeated_substring_patter_459;

public class Main {

    public static void main(String[] args) {

    }

    public boolean repeatedSubstringPattern(String s) {

        int[] phi = new int[s.length()];
        int i = 0, j = 1;

        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                phi[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = phi[i - 1];
                } else j++;
            }
        }

        int n = s.length() - phi[s.length() - 1];

        return n != s.length() && s.length() % n == 0;
    }

}
