package string_compress_443;

public class Main {
    public static void main(String args[]) {

    }

    public static int compress(char[] chars) {
        int index = 0, posStart = 0;
        while (index < chars.length) {
            int counter = 0;
            char temp = chars[index];
            while (index < chars.length && chars[index] == temp) {
                index++;
                counter++;
            }
            chars[posStart++] = temp;
            if (counter > 1) {
                for (char c : Integer.toString(counter).toCharArray()) {
                    chars[posStart++] = c;
                }
            }
        }
        return posStart;
    }

}
