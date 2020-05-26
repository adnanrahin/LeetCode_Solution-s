package minimum_window_substring_76;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        int freq[] = new int[128];

        for (int i = 0; i < t.length(); i++)
            freq[t.charAt(i) - 'A']++;

        int right = 0, left = 0, size = Integer.MAX_VALUE, counter = t.length(), ptr = 0;

        while (right < s.length()) {

            if (freq[s.charAt(right++) - 'A']-- > 0)
                counter--;

            while (counter == 0) {
                if (right - left < size) {
                    size = right - left;
                    ptr = left;
                }
                if (freq[s.charAt(left++) - 'A']++ == 0)
                    counter++;
            }

        }

        return size == Integer.MAX_VALUE ? "" : s.substring(ptr, ptr + size);
    }
}
