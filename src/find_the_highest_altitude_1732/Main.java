package find_the_highest_altitude_1732;

public class Main {

    public static void main(String[] args) {

        System.out.println(Solution.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));

    }
}

class Solution {
    public static int largestAltitude(int[] gain) {
        int altitude = 0, sum = Integer.MIN_VALUE;

        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            sum = Math.max(sum, altitude);
        }

        return Math.max(sum, 0);
    }
}
