package shuffle_the_array_1470;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));

    }

    public static int[] shuffle(int[] nums, int n) {

        int[] solution = new int[nums.length];

        for (int i = 0, cur = 0; i < n; i++) {
            solution[cur] = nums[i];
            solution[cur + 1] = nums[i + n];
            cur += 2;
        }
        return solution;

    }

}
