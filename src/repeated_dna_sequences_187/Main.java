package repeated_dna_sequences_187;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> solution = new HashSet<>();
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        if(s.length() < 10) return new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            sb.append(s.charAt(i));
        }

        set.add(sb.toString());

        for (int i = 10; i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            if (!set.add(sb.toString())) {
                solution.add(sb.toString());
            }
        }

        return new ArrayList<>(solution);
    }

}
