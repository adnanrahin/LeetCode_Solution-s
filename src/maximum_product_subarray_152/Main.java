package maximum_product_subarray_152;

public class Main {

    public static void main(String[] args) {

        System.out.println(maxProduct(new int[]{2, 3, 1, 0, 9, 6}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{1, -1}));
        System.out.println(maxProduct(new int[]{-3}));
        System.out.println(maxProduct(new int[]{0, 2}));
        System.out.println(maxProduct(new int[]{-1, 1}));
        System.out.println(maxProduct(new int[]{-1, 0}));
        System.out.println(maxProduct(new int[]{11, 0}));
        System.out.println(maxProduct(new int[]{-4, -3, -2}));
        System.out.println(maxProduct(new int[]{3, -1, 4}));
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
        System.out.println(maxProduct(new int[]{-5, 0, 2}));
        System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3}));
        System.out.println(maxProduct(new int[]{2, -1, 1, 1}));
    }

    public static int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (nums[i] == 0) product = 1;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if(nums[i] == 0) product = 1;
        }
        return maxProduct;
    }

}
