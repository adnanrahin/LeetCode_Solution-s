package backspace_string_compare_844;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(backspaceCompare("a##c", "c#d#"));

    }

    public static boolean backspaceCompare(String S, String T) {

        List<Character> sString = new ArrayList<>();
        List<Character> tString = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isAlphabetic(S.charAt(i))) {
                sString.add(S.charAt(i));
            } else if (S.charAt(i) == '#' && sString.size() != 0)
                sString.remove(sString.size() - 1);
        }

        for (int i = 0; i < T.length(); i++) {
            if (Character.isAlphabetic(T.charAt(i))) {
                tString.add(T.charAt(i));
            } else if (T.charAt(i) == '#' && tString.size() != 0) {
                tString.remove(tString.size() - 1);
            }
        }

        System.out.println(sString + " " + tString);

        return sString.equals(tString);

    }

}
