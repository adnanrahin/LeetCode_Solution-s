package sliding_window_maximum_239;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] solution = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();

            deque.addLast(i);
        }

        for (int i = k; i < nums.length; i++) {

            solution[i - k] = nums[deque.peekFirst()];

            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.removeFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();

            deque.addLast(i);
        }

        solution[solution.length - 1] = nums[deque.peekFirst()];

        return solution;

    }

}
