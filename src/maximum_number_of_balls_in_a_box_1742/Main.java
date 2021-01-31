package maximum_number_of_balls_in_a_box_1742;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public static int countBalls(int lowLimit, int highLimit) {
        int maxBalls = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = lowLimit; i <= highLimit; i++) {
            int bucket = getSumOfBalls(i);
            freq.put(bucket, freq.getOrDefault(bucket, 0) + 1);
            maxBalls = Math.max(maxBalls, freq.get(bucket));
        }

        return maxBalls;
    }

    public static int getSumOfBalls(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

}
