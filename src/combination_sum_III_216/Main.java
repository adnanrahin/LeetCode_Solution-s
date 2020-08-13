package combination_sum_III_216;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(combinationSum3(4, 24));

    }

    static List<List<Integer>> solution;

    public static List<List<Integer>> combinationSum3(int k, int n) {
        solution = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>());
        return solution;
    }

    public static void backtrack(int start, int k, int sum, List<Integer> list) {

        if (sum == 0 && list.size() == k) {
            solution.add(new ArrayList<>(list));
            return;
        }

        if (sum < 0 || list.size() > k) return;

        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtrack(i + 1, k, sum - i, list);
            list.remove(list.size() - 1);
        }
    }

}
