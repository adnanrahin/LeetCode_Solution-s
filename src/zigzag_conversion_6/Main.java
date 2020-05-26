package zigzag_conversion_6;

public class Main {

    public static void main(String args[]) {

    }

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        int cycle = (2 * numRows) - 2;

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += cycle) {
                stringBuffer.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && (j + cycle - i) < s.length())
                    stringBuffer.append(s.charAt(j + cycle - i));
            }
        }

        return stringBuffer.toString();
    }

}
