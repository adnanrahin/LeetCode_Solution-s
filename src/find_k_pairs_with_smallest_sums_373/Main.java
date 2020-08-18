package find_k_pairs_with_smallest_sums_373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) {

        System.out.println(kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> solution = new ArrayList<>();

        k = Math.min(nums1.length * nums2.length, k);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++)
            pq.add(new int[]{nums1[i], nums2[0], 0});

        for (int i = 0; i < k; i++) {
            int arr[] = pq.poll();
            solution.add(Arrays.asList(arr[0], arr[1]));
            if (arr[2] < nums2.length - 1) {
                pq.add(new int[]{arr[0], nums2[++arr[2]], arr[2]});
            }
        }

        return solution;

    }
}
