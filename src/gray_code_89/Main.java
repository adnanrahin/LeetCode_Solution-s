package gray_code_89;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(new Solution().grayCode(2));

    }

    public static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < (1 << n); i++) {
                result.add(i ^ (i >> 1));
            }
            return result;
        }
    }
}
