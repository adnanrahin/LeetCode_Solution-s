package kids_with_the_greatest_number_of_candies_1431;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> solution = new ArrayList<>();
        int greatestNumberOfCandies = candies[0];

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > greatestNumberOfCandies)
                greatestNumberOfCandies = candies[i];
        }

        for (int i = 0; i < candies.length; i++) {
            solution.add(candies[i] + extraCandies >= greatestNumberOfCandies);
        }

        return solution;

    }

}
