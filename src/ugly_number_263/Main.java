package ugly_number_263;

public class Main {

    public static void main(String args[]) {
        System.out.println(new Solution().isUgly(0));
    }

    static class Solution {
        public boolean isUgly(int num) {
            for (int a : new int[]{2, 3, 5}) {
                while (num % a == 0)
                    num /= a;
            }
            return num == 0;
        }
    }

}
