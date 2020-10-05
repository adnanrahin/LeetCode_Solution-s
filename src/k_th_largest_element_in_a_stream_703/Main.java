package k_th_largest_element_in_a_stream_703;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[ ]args){

    }

}
class KthLargest {

    PriorityQueue<Integer> pq;

    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() == k) {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            } else pq.add(nums[i]);
        }
    }

    public int add(int val) {
        if (pq.size() == k) {
            if (pq.peek() < val) {
                pq.poll();
                pq.add(val);
            }
        } else pq.add(val);
        return pq.peek();
    }
}