package largest_substring_between_two_equal_characters_1624;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));

    }

    public static int maxLengthBetweenEqualCharacters(String s) {

        if (s.length() == 0) return 0;

        int distance = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                distance = Math.max(distance, i - map.get(s.charAt(i)));
                continue;
            }
            map.put(s.charAt(i), i);
        }

        return distance - 1;

    }

}
