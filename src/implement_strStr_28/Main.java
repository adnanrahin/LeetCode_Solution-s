package implement_strStr_28;

public class Main {

    public static void main(String args[]) {

    }

    public static class KPMSolution {
        public static int strStr(String text, String pattern) {

            int[] pi = piTable(text, pattern);

            for (int i = pattern.length(); i < pi.length; i++) {
                if (pi[i] == pattern.length()) {
                    return i - 2 * pattern.length();
                }
            }

            return -1;
        }

        public static int[] piTable(String text, String pattern) {
            String str = pattern + "#" + text;
            int[] pi = new int[str.length()];

            int i = 0, j = 1;

            while (j < str.length()) {
                if (str.charAt(i) == str.charAt(j)) {
                    pi[j] = i + 1;
                    i++;
                    j++;
                } else {
                    if (i == 0) {
                        pi[j] = 0;
                        j++;
                    } else i = pi[i - 1];
                }
            }

            return pi;
        }
    }

    public static class RabinKarpSolution {
        public static int strStr(String text, String pattern) {

            int m = pattern.length();
            int n = text.length();

            if (n < m) return -1;

            int largePrime = 599;
            int patternHash = 0, textHash = 0;
            int am = 1;

            for (int i = 0; i < m; ++i) {
                patternHash = (patternHash * 256 + pattern.charAt(i)) % largePrime;
                textHash = (textHash * 256 + text.charAt(i)) % largePrime;
                if (i < pattern.length() - 1)
                    am = (am * 256) % largePrime;
            }

            for (int i = 0; i < n - m; ++i) {
                if (patternHash == textHash && pattern.equals(text.substring(i, i + m))) {
                    return i;
                }

                textHash = (((textHash - text.charAt(i) * am) * 256) + text.charAt(i + m)) % largePrime;

                if (textHash < 0)
                    textHash += largePrime;
            }

            if (patternHash == textHash && pattern.equals(text.substring(n - m, n)))
                return n - m;

            return -1;
        }
    }

}
