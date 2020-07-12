package sum_of_subsequence_widths_891;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(sumSubseqWidths(new int[]{2, 1, 3}));

    }

    public static int sumSubseqWidths(int[] A) {

        long sum = 0;
        Arrays.sort(A);
        int n = A.length;
        long[] powerOfTwo = new long[n];

        powerOfTwo[0] = 1;

        for (int i = 1; i < n; i++)
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % (int) (1e9 + 7);

        for (int i = 0; i < n; i++)
            sum = (sum + (powerOfTwo[i] - powerOfTwo[n - i - 1]) * A[i]) % (int) (1e9 + 7);

        return (int) sum;
    }
}
