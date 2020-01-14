package convert_integer_to_the_sum_of_two_no_zero_integers_1317;

public class Main {

    public static void main(String args[]){

    }

    public static int[] getNoZeroIntegers(int n) {

        int[] solution = new int[2];

        for (int i = 1; i < n; i++) {

            int sol = n - i;

            if (isZero(sol) && isZero(i)) {
                return new int[]{i, sol};
            }

        }

        return solution;

    }

    public static boolean isZero(int n) {

        int number = n;

        while (number != 0) {
            int mod = number % 10;
            number /= 10;
            if (mod == 0)
                return false;
        }

        return true;
    }

}
