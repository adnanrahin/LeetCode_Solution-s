package special_array_wit_x_elements_greater_or_equal_x_1608;

public class Main {

    public static void main(String[] args) {

    }

    public static int specialArray(int[] nums) {

        for (int i = 0; i <= nums.length; i++) {
            int counter = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) counter++;
            }
            if (counter == i) return i;
        }

        return -1;
    }


}
