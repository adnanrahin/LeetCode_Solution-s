package pow_of_x_n_50;

public class Main {

    public static void main(String[] args) {

    }

    public static double myPow(double x, int n) {
        double ans = 1;
        long itr = Math.abs((long) n);
        while (itr > 0) {
            if (itr % 2 == 1) ans *= x;
            x *= x;
            itr /= 2;
        }
        return n < 0 ? 1 / ans : ans;
    }
}
