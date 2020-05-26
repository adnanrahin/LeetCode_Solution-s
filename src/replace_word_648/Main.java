package replace_word_648;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(replaceWords(new ArrayList<>(Arrays.asList("cat", "catt", "battle", "bat", "rat")),
				"the cattle was rattled by the battery"));
	}

	public static String replaceWords(List<String> dict, String sentence) {

		String[] words = sentence.split(" ");

		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i] + " ");
		}

		for (int i = 0; i < dict.size(); i++) {

			for (int j = 0; j < words.length; j++) {
				String cr = dict.get(i);
				if (words[j].length() >= cr.length()) {
					String change = words[j].substring(0, cr.length());
					if (dict.get(i).equals(change)) {
						words[j] = words[j].replace(words[j], change);
					}
				}
			}

		}

		StringBuffer sBuffer = new StringBuffer();

		for (int i = 0; i < words.length; i++) {

			if (i == words.length - 1) {
				sBuffer.append(words[i]);
			} else {
				sBuffer.append(words[i] + " ");
			}

		}

		return sBuffer.toString();

	}

}
