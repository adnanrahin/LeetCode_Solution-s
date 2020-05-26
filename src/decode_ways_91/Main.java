package decode_ways_91;

public class Main {

    public static void main(String args[]) {

    }

    public static int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int first = s.charAt(i - 1) - '0';
            int second = (s.charAt(i - 2) - '0') * 10 + first;

            if (first >= 1) dp[i] += dp[i - 1];
            if (second >= 1 && second <= 26) dp[i] += dp[i - 2];

        }

        return dp[s.length()];
    }

}
