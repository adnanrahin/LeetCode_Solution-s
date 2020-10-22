package range_sum_query_Immutable_303;

public class Main {
    public static void main(String[] args) {

    }
}

class NumArray {

    private int[] arr;

    public NumArray(int[] nums) {
        if (nums.length != 0) {
            arr = new int[nums.length];
            arr[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                arr[i] = arr[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (arr.length == 0) return 0;
        if (i == 0) return arr[j];
        else return arr[j] - arr[i - 1];
    }
}
