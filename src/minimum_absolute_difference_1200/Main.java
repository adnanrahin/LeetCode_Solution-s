package minimum_absolute_difference_1200;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //System.out.println(minimumAbsDifference(new int[]{4, 2, 1, 3}));
        //System.out.println(minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
        System.out.println(minimumAbsDifference(new int[]{-25, -51, -29, -23, 57, -18}));

    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> solution = new ArrayList<>();

        if (arr.length == 0) {
            return solution;
        }
        int min = Math.abs(arr[0] - arr[1]);

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i + 1]));
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) == min)
                solution.add(Arrays.asList(arr[i], arr[i + 1]));

        }
        return solution;
    }

}
