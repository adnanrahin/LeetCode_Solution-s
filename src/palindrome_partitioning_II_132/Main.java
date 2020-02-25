package palindrome_partitioning_II_132;

public class Main {

    public static void main(String args[]) {

        System.out.println(minCut("aab"));

    }

    public static int minCut(String s) {
        int dp[] = new int[s.length()];

        for (int i = 0; i < s.length(); i++)
            dp[i] = i;

        for (int i = 1; i < s.length(); i++) {
            for (int start = i, end = i; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                int curPoint = start == 0 ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], curPoint);
            }

            for (int start = i - 1, end = i; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                int curPoint = start == 0 ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], curPoint);
            }
        }
        return dp[s.length() - 1];
    }

}
