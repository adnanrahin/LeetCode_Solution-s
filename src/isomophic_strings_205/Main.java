package isomophic_strings_205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

	}

	public static boolean isIsomorphic(String s, String t) {
		
		int v1[] = new int [s.length()];
		int v2[] = new int [t.length()];
		
		v1 = visited(v1, s);
		v2 = visited(v2, t);
		
		if(Arrays.equals(v1, v2)) return true;
		else return false;
	}
	
	private static int[] visited(int[] v, String word) {
		int k = 1;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			if (!map.containsKey(word.charAt(i))) {
				map.put(word.charAt(i), k++);
			}
		}
		for (int i = 0; i < word.length(); i++) {
			v[i] = map.get(word.charAt(i));
		}
		return v;
	}
	
}
