package making_file_names_unique_1487;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        System.out.println(Arrays.toString(
                new Solution().getFolderNames(new String[]{"abc", "abc", "abc(1)", "abc"})));

        System.out.println(Arrays.toString(
                new Solution().getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"})));

        System.out.println(Arrays.toString(
                new Solution().getFolderNames(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"})));

    }

    static class Solution {
        public String[] getFolderNames(String[] names) {

            Map<String, Integer> folderStructure = new HashMap<>();

            String[] result = new String[names.length];

            for (int i = 0; i < names.length; i++) {

                if (!folderStructure.containsKey(names[i])) {
                    result[i] = names[i];
                    folderStructure.put(names[i], 1);
                } else if (folderStructure.containsKey(names[i])) {

                    int counter = folderStructure.get(names[i]);

                    String newKey = names[i] + "(" + counter + ")";

                    while (folderStructure.containsKey(newKey)) {
                        counter++;
                        newKey = names[i] + "(" + counter + ")";
                    }

                    folderStructure.put(newKey, 1);
                    folderStructure.put(names[i], counter);
                    result[i] = newKey;
                }

            }

            return result;
        }
    }

}
