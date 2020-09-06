package replace_all_to_avoid_consecutive_repeating_characters_1576;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(modifyString("????v??"));
    }

    public static String modifyString(String s) {

        if (s.length() == 1) return "a";

        Map<Long, Character> map = new HashMap<>();

        for (char a = 'a'; a <= 'z'; a++) map.put((long) ((int) a - 'a'), a);

        char[] solution = s.toCharArray();

        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == '?' && i == 0) {
                long hash = Math.abs(((solution[i + 1] - 'a') + i + (int) (1e9) % 8861) * 102023);
                while (map.get(hash % 26) == solution[i + 1]) {
                    hash = Math.abs((hash + (int) (1e9) % 8861) * 102023);
                }
                solution[i] = map.get(hash % 26);
            } else if (solution[i] == '?' && i == solution.length - 1) {
                long hash = Math.abs(((solution[i - 1] - 'a') + i + (int) (1e9) % 8861) * 102023);
                while (map.get(hash % 26) == solution[i - 1]) {
                    hash = Math.abs((hash + (int) (1e9) % 8861) * 102023);
                }
                solution[i] = map.get(hash % 26);
            } else if (solution[i] == '?') {
                long hash = Math.abs(((solution[i - 1] - 'a') + (solution[i + 1] - 'a') + i + (int) (1e9) % 8861) * 102023);
                while (map.get(hash % 26) == solution[i + 1]) {
                    hash = Math.abs((hash + (int) (1e9) % 8861) * 102023);
                }
                while (map.get(hash % 26) == solution[i - 1]) {
                    hash = Math.abs((hash + (int) (1e9) % 8861) * 102023);
                }
                solution[i] = map.get(hash % 26);
            }
        }
        return new String(solution);
    }
}
