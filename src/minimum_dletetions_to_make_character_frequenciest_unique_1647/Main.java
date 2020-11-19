package minimum_dletetions_to_make_character_frequenciest_unique_1647;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public static int minDeletions(String s) {

        Map<Character, Integer> frequencies = new HashMap<>();

        for (char ch : s.toCharArray()) {
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        }

        return 0;
    }

}
