package longest_uncommon_subsequence_II_522;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {

        System.out.println(findLUSlength(new String[]{"aaa", "aaa", "a"}));

    }

    public static boolean isSubsequence(String a, String b) {
        int i = 0;
        int j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == b.length();
    }

    public static int findLUSlength(String[] strs) {

        Arrays.sort(strs, (x, y) -> Integer.compare(y.length(), x.length()));

        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[j], strs[i])) break;
            }
            if (j == strs.length) return strs[i].length();
        }

        return -1;
    }
}
