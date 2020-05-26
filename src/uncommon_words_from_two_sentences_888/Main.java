package uncommon_words_from_two_sentences_888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		System.out.println(uncommonFromSentences("this apple is sweet", "this apple is sour"));
		System.out.println(uncommonFromSentences("apple apple", "bannana"));
		System.out.println(uncommonFromSentences("gw pk xy", "gw aje zqd"));
	}

	public static String[] uncommonFromSentences(String A, String B) {

		String word_1[] = A.split(" ");
		String word_2[] = B.split(" ");

		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i<word_1.length; i++) {
			
			if(!map.containsKey(word_1[i])) {
				map.put(word_1[i], 1);
			}
			else { 
				int temp = map.get(word_1[i]) + 1;
				map.put(word_1[i], temp);
			}
		}
		for(int i = 0; i<word_2.length; i++) {
			
			if(!map.containsKey(word_2[i])) {
				map.put(word_2[i], 1);				
			}
			else {
				int temp = map.get(word_2[i]) + 1;
				map.put(word_2[i], temp);
			}
	
		}
		
		List<String> list = new ArrayList<>();
		
		for(Map.Entry<String, Integer> It: map.entrySet()) {
			if(It.getValue() == 1)
				list.add(It.getKey());
		}
		
		String a[] = new String[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			a[i] = list.get(i);
		}
		return a;
	}

}
