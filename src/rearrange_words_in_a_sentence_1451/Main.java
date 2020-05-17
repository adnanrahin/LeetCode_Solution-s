package rearrange_words_in_a_sentence_1451;

import java.util.*;

public class Main {

    public static void main(String args[]) {

    }

    public static String arrangeWords(String text) {

        text = text.toLowerCase();

        String[] str = text.split(" ");


        Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            if (!map.containsKey(str[i].length())) map.put(str[i].length(), new ArrayList<>());
            map.get(str[i].length()).add(str[i]);
        }

        List<Integer> keySet = new ArrayList<>();

        for (Integer key : map.keySet()) keySet.add(key);

        Collections.sort(keySet);

        String reString = "";

        for (int i = 0; i < keySet.size(); i++) {
            List<String> strings = map.get(keySet.get(i));
            for (int j = 0; j < strings.size(); j++)
                reString += strings.get(j) + " ";
        }
        reString = reString.substring(0, 1).toUpperCase() + reString.substring(1, reString.length() - 1);
        return reString;
    }

}
