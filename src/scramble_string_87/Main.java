package scramble_string_87;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(new Solution().isScramble("great", "rgeat"));

    }

    public static class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1.length() != s2.length())
                return false;

            if (s1.length() == 0 || s1.equals(s2))
                return true;

            char[] str1 = s1.toCharArray();
            char[] str2 = s2.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);

            if (!Arrays.toString(str1).equals(Arrays.toString(str2))) return false;

            for (int i = 1; i < s1.length(); i++) {
                String a = s1.substring(0, i);
                String b = s1.substring(i);
                String c = s2.substring(0, i);
                String d = s2.substring(i);
                String e = s2.substring(0, s2.length() - i);
                String f = s2.substring(s2.length() - i);

                if (isScramble(a, c) && isScramble(b, d) || isScramble(a, f) && isScramble(b, e))
                    return true;
            }

            return false;
        }

    }
}
