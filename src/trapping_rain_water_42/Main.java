package trapping_rain_water_42;

public class Main {

    public static void main(String args[]) {

        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{2, 0, 2}));

    }

    public static int trap(int[] height) {

        int sum = 0;

        if (height.length == 0)
            return sum;

        int left[] = new int[height.length];
        int right[] = new int[height.length];

        int max = height[0];

        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }

        max = height[height.length - 1];

        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            right[i] = max;
        }

        for (int i = 0; i < height.length; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }

        return sum;

    }

}
