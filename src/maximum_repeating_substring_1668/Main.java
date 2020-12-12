package maximum_repeating_substring_1668;

public class Main {

    /*[0, 1, 2, 0, 1, 0, 1, 2, 3, 4, 5,
    2, 3, 3, 4, 5, 2, 3, 4, 5,
    2, 3, 3, 4, 5,
    2, 3, 3, 4, 5,
    2, 3, 3, 4, 5,
    2, 3, 3, 4, 5]*/

    public static void main(String[] args) {

    }

    public static int maxRepeating(String sequence, String word) {

        int count = 0;
        String str = word;

        while (sequence.contains(str)) {
            count++;
            str += word;
        }
        return count;
    }

}
