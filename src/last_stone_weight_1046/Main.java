package last_stone_weight_1046;

import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) {

        PriorityQueue<Single> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Single(10));
        priorityQueue.add(new Single(15));

        System.out.println(priorityQueue.poll().val);

    }

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Single> pq = new PriorityQueue<>();

        for (int i = 0; i < stones.length; i++) {
            pq.add(new Single(stones[i]));
        }

        while (!pq.isEmpty()) {

            if (pq.size() > 1) {
                int x = pq.poll().val;
                int y = pq.poll().val;
                if (x == y) continue;
                else pq.add(new Single(Math.abs(x - y)));
            }
            if (pq.size() == 1) return pq.peek().val;

        }

        return 0;
    }

    public static class Single implements Comparable<Single> {
        int val;

        public Single(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Single single) {
            if (this.val > single.val) return -1;
            else if (this.val < single.val) return 1;
            return 0;
        }

    }

}
