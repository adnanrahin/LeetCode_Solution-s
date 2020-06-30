package unique_substring_in_wraparound_string_467;

public class Main {

    public static void main(String args[]) {

    }

    public int findSubstringInWraproundString(String p) {

        int counter = 0;
        int maxLenCounter = 0;

        int[] dp = new int[26];

        for (int i = 0; i < p.length(); i++) {

            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25))
                maxLenCounter++;
            else maxLenCounter = 1;

            int index = p.charAt(i) - 'a';

            dp[index] = Math.max(dp[index], maxLenCounter);
        }

        for (int i = 0; i < dp.length; i++)
            counter += dp[i];

        return counter;
    }

}
