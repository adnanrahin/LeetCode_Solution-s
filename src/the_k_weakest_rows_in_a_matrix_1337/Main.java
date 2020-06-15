package the_k_weakest_rows_in_a_matrix_1337;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) {

        int[][] mat =
                {{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}};

        System.out.println(Arrays.toString(new Solution().kWeakestRows(mat, 3)));
    }

    public static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {

            if(mat.length == 0) return new int[]{};

            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

            for (int i = 0; i < mat.length; i++) {
                int soldiers = binary_search(mat[i]);
                priorityQueue.add(new Pair(i, soldiers));
            }

            int[] solution = new int[k];

            for (int i = 0; i < k; i++)
                solution[i] = priorityQueue.poll().row;

            return solution;
        }

        public int binary_search(int arr[]) {

            int left = 0;
            int right = arr.length - 1;
            int index = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == 1) {
                    index = mid;
                    left = mid + 1;
                } else right = mid - 1;
            }
            return index + 1;
        }

        public class Pair implements Comparable<Pair> {
            int row, val;
            Pair(int row, int val) {
                this.row = row;
                this.val = val;
            }
            public int compareTo(Pair p) {
                if (this.val == p.val) return this.row - p.row;
                return this.val - p.val;
            }
        }

    }


}
