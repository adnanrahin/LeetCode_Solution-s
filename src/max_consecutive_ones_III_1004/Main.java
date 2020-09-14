package max_consecutive_ones_III_1004;

public class Main {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    public static int longestOnes(int[] nums, int k) {

        int maxConsecutiveOnes = 0;
        int local = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }
            local++;
            while (k < 0) {
                if (nums[left++] == 0) {
                    k++;
                }
                local--;
            }
            maxConsecutiveOnes = Math.max(local, maxConsecutiveOnes);
            right++;
        }
        return maxConsecutiveOnes;
    }

}
