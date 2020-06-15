package additive_number_306;

public class Main {

    public static void main(String[] args) {

    }

    class Solution {
        public boolean isAdditiveNumber(String num) {

            int n = num.length();

            for (int i = 1; i <= n / 2; i++) {
                for (int j = 1; Math.max(i, j) <= n - i - j; j++)
                    if (canFormNextNumber(i, j, num)) return true;
            }
            return false;
        }

        public boolean canFormNextNumber(int i, int j, String str) {
            if (str.charAt(0) == '0' && i > 1) return false;
            if (str.charAt(i) == '0' && j > 1) return false;
            String sum;
            Long x = Long.parseLong(str.substring(0, i));
            Long y = Long.parseLong(str.substring(i, i + j));
            for (int start = i + j; start != str.length(); start += sum.length()) {
                y = y + x;
                x = y - x;
                sum = y.toString();
                if (!str.startsWith(sum, start)) return false;
            }
            return true;
        }
    }

}
