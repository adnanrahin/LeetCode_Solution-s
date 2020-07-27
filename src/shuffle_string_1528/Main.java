package shuffle_string_1528;

public class Main {
    public static void main(String[] args) {

        System.out.println();

    }

    public static String restoreString(String s, int[] indices) {
        char[] newChar = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            newChar[indices[i]] = s.charAt(i);
        }

        return new String(newChar);
    }

}
