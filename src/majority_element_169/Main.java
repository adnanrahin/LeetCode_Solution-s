package majority_element_169;

public class Main {

    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {

        Integer elm = null;

        int count = 0;

        for (Integer num : nums) {

            if (count == 0) {
                elm = num;
            }

            if (num.equals(elm))
                count++;
            else count--;
        }

        return elm;

    }
}
