package find_the_town_judge_997;

public class Main {

    public static void main(String args[]) {

    }

    public int findJudge(int N, int[][] trust) {

        int[] dp = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            dp[trust[i][0]]--;
            dp[trust[i][1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (dp[i] == N - 1)
                return i;
        }

        return -1;

    }
}
