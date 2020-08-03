package pascals_triangle_118;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(generate(5));
        System.out.println(generate(6));

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> local = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) local.add(1);
                else {
                    int a = triangle.get(i - 2).get(j - 1);
                    int b = triangle.get(i - 2).get(j - 2);
                    local.add(a + b);
                }
            }
            triangle.add(new ArrayList<>(local));
        }

        return triangle;

    }

}
