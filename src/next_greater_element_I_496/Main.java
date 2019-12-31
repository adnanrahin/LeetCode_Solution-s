package next_greater_element_I_496;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String args[]) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);

        int solution[] = new int[nums1.length];

        Arrays.fill(solution, -1);

        for (int i = 0; i < nums1.length; i++) {

            int num = nums1[i];

            for (int j = i; j < nums2.length; j++) {

                if (num < nums2[j] && !set.contains(nums2[j])) {
                    solution[i] = nums2[j];
                    break;
                }

            }

        }

        return solution;
    }

}
