package truncate_sentence_1816;

public class Main {

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
    }

    public static String truncateSentence(String s, int k) {
        String solution = "";
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (counter < k) {
                if (s.charAt(i) == ' ')
                    counter++;
                if (counter != k)
                    solution += s.charAt(i);
            }
        }
        return solution;
    }

}
