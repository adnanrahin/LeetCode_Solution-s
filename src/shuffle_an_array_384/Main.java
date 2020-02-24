package shuffle_an_array_384;

import java.util.Random;

public class Main {

    public static void main(String args[]) {

    }

    class Solution {

        int[] original;
        int[] shuffle;

        public Solution(int[] nums) {
            original = nums.clone();
            shuffle = nums.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return original;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {

            Random random = new Random();

            for (int i = 0; i < shuffle.length; i++) {

                int rand = random.nextInt(shuffle.length);

                int temp = shuffle[rand];
                shuffle[rand] = shuffle[i];
                shuffle[i] = temp;

            }

            return shuffle;
        }
    }

}
