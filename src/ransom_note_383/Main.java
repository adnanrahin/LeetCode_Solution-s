package ransom_note_383;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		System.out.println(canConstruct("aa", "ab")); // true
		System.out.println(canConstruct("a", "")); // false
		System.out.println(canConstruct("", "a")); // true
		System.out.println(canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh")); // true
		System.out.println(canConstruct("bjaajgea",
				"affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < magazine.length(); i++) {
			if (!map.containsKey(magazine.charAt(i))) {
				map.put(magazine.charAt(i), 1);
			} else
				map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) == 0) {
				return false;
			}
			map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
		}
		return true;
	}

}
