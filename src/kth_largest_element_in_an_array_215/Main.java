package kth_largest_element_in_an_array_215;

import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) {

        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(findKthLargest(new int[]{-1, 0, 1, 1, 2, 3}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else if (pq.size() == k) {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }

    public class Solution {
        int findKthLargest(int[] arr, int k) {

            int low = 0;
            int high = arr.length - 1;

            while (low < high) {
                int partition = partition(arr, low, high);
                if (partition == arr.length - k) return arr[partition];
                else if (partition > arr.length - k) high = partition - 1;
                else low = partition + 1;
            }

            return arr[low];
        }

        public int partition(int[] arr, int low, int high) {

            int pivot = arr[high];
            int i = low;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                }
            }
            int temp = arr[i];
            arr[i] = arr[high];
            arr[high] = temp;
            return i;
        }
    }

}
