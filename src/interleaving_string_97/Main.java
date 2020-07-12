package interleaving_string_97;

public class Main {
    public static void main(String[] args) {

        System.out.println(isInterleave("aab", "axy", "aaxaby"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("aabc", "abad", "aabadabc"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i <= s2.length(); i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                dp[0][i] = dp[0][i - 1];
            } else dp[0][i] = false;
        }

        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            } else dp[i][0] = false;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int l = i + j - 1;
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(l) && dp[i - 1][j])
                        || (s2.charAt(j - 1) == s3.charAt(l) && dp[i][j - 1]);
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
