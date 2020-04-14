package repeated_substring_pattern_459;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abaababaab"));

    }

    public static boolean repeatedSubstringPattern(String s) {

        if (s.length() < 2) return false;

        int[] prefix = new int[s.length()];

        int i = 0;
        int j = 1;

        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                prefix[j] = i + 1;
                i++;
                j++;
            } else if (s.charAt(i) != s.charAt(j) && i > 0) {
                i = prefix[i - 1];

            } else if (s.charAt(i) != s.charAt(j) && i == 0) {
                prefix[j] = 0;
                j++;
            }
        }

        if (prefix[prefix.length - 1] == 0) return false;
        if (s.length() % (s.length() - prefix[prefix.length - 1]) != 0) return false;
        return true;

    }
}
