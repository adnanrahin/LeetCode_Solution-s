package prison_cells_after_n_days_957;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String args[]) {

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));

    }
}

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {

        Set<String> set = new HashSet<>();
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            int new_cell[] = findNeighbours(cells);
            String str = Arrays.toString(new_cell);
            if (!set.contains(str)) {
                set.add(str);
            } else {
                flag = true;
                break;
            }
            cells = new_cell;
        }
        if (flag) {
            N = N % set.size();
            for (int i = 0; i < N; i++)
                cells = findNeighbours(cells);
        }

        return cells;
    }


    public int[] findNeighbours(int[] cells) {

        int[] new_cells = new int[cells.length];

        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1])
                new_cells[i] = 1;
        }

        return new_cells;

    }

}
