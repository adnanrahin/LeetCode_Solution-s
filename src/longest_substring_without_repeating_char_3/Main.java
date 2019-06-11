package longest_substring_without_repeating_char_3;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
		System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
		System.out.println(lengthOfLongestSubstring("dvdf")); // 3
		System.out.println(lengthOfLongestSubstring("anviaj")); // 5
		System.out.println(lengthOfLongestSubstring("ckilbkd")); // 5
		System.out.println(lengthOfLongestSubstring("tmmzuxt")); // 5
		System.out.println(lengthOfLongestSubstring("bbtablud")); // 6
		System.out.println(lengthOfLongestSubstring("wobgrovw")); // 6

	}

	
	
	public static int lengthOfLongestSubstring(String s) {
		
		int temp = 0, count = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++) {
			
			if(map.containsKey(s.charAt(i))) {
				count = (map.get(s.charAt(i)) > count) ? map.get(s.charAt(i)) : count;
			}

			temp = (temp > i - count + 1) ? temp : i - count + 1;
			
			map.put(s.charAt(i), i+1);
			
		}
		
		return temp;
	}

}
