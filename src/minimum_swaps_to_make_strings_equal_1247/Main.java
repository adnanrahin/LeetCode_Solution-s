package minimum_swaps_to_make_strings_equal_1247;

public class Main {

    public static void main(String args[]) {

        System.out.println(minimumSwap("xx", "yy"));
        System.out.println(minimumSwap("xy", "yx"));
        System.out.println(minimumSwap("xx", "xy"));
        System.out.println(minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
        System.out.println(1 % 5);

    }

    public static int minimumSwap(String s1, String s2) {

        int xy = 0;
        int yx = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y')
                xy++;
            if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x')
                yx++;
        }

        if ((xy + yx) % 2 == 1)
            return -1;

        return xy / 2 + yx / 2 + (xy % 2) * 2;

    }

}
