package least_number_of_unique_integers_after_k_removals_1481;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) {

        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{1, 2, 2, 2, 2}, 4));

    }

    static class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {

            Map<Integer, Integer> frequency = new HashMap<>();

            for (int i = 0; i < arr.length; i++)
                frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);

            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

            for (Integer key : frequency.keySet())
                priorityQueue.add(new Pair(key, frequency.get(key)));

            int index = 0;

            while (index < k) {

                Pair pair = priorityQueue.poll();
                pair.freq--;
                if (pair.freq > 0)
                    priorityQueue.add(new Pair(pair.number, pair.freq));

                index++;
            }

            return priorityQueue.size();
        }

        public class Pair implements Comparable<Pair> {

            int number;
            int freq;

            public Pair(int number, int freq) {
                this.number = number;
                this.freq = freq;
            }

            @Override
            public int compareTo(Pair o) {
                return Integer.compare(this.freq, o.freq);
            }
        }
    }

}
