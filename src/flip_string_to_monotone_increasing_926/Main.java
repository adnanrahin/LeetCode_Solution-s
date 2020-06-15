package flip_string_to_monotone_increasing_926;

public class Main {

    public static void main(String args[]) {

        System.out.println(new Solution().minFlipsMonoIncr("010001010101000001"));

    }

    static class Solution {
        public int minFlipsMonoIncr(String S) {
            int zeroCounter = 0;
            int oneCounter = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '0')
                    zeroCounter++;
                else oneCounter++;

                oneCounter = Math.max(oneCounter, zeroCounter);

            }
            return S.length() - oneCounter;
        }
    }

}
