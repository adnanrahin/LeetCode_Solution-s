package corporate_flight_bookings_1109;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new int[]{}));

    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] v : bookings) {
            int start = v[0];
            int end = v[1];
            int k = v[2];
            res[start - 1] += k;
            if (end < n) res[end] -= v[2];
        }
        for (int i = 1; i < n; ++i) res[i] += res[i - 1];
        return res;
    }

}
