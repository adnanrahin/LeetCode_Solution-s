package split_a_string_in_balanced_strings_1221;

public class Main {

    public static void main(String args[]) {

        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));

    }

    public static int balancedStringSplit(String s) {

        int splitString = 0;

        int rCounter = 0;
        int lCounter = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'R')
                rCounter++;
            else if (s.charAt(i) == 'L')
                lCounter++;

            if (rCounter == lCounter)
                splitString++;

        }

        return splitString;

    }
}
