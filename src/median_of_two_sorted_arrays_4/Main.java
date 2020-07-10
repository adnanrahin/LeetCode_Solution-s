package median_of_two_sorted_arrays_4;

public class Main {
    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[]{1, 3,}, new int[]{2, 4}));

    }


    public static double findMedianSortedArrays(int nums1[], int nums2[]) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int one = nums1.length;
        int two = nums2.length;

        int low = 0;
        int high = one;

        while (low <= high) {
            int pivotOne = (low + high) / 2;
            int pivotTwo = (one + two + 1) / 2 - pivotOne;

            int oneLeftMax = (pivotOne == 0) ? Integer.MIN_VALUE : nums1[pivotOne - 1];
            int oneRightMin = (pivotOne == one) ? Integer.MAX_VALUE : nums1[pivotOne];

            int twoLeftMax = (pivotTwo == 0) ? Integer.MIN_VALUE : nums2[pivotTwo - 1];
            int twoRightMin = (pivotTwo == two) ? Integer.MAX_VALUE : nums2[pivotTwo];

            if (oneLeftMax <= twoRightMin && twoLeftMax <= oneRightMin) {
                if ((one + two) % 2 == 0) {
                    return ((double) Math.max(oneLeftMax, twoLeftMax) + Math.min(oneRightMin, twoRightMin)) / 2;
                } else {
                    return Math.max(oneLeftMax, twoLeftMax);
                }
            } else if (oneLeftMax > twoRightMin) {
                high = pivotOne - 1;
            } else {
                low = pivotOne + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
