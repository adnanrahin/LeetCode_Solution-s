package decode_ways_91;


public class Main {

	public static void main(String args[]) {
		
		numDecodings("2496");
		
	}

	public static int numDecodings(String s) {
		
		if(s.length() == 0) return 0;
		if(s.equals("0")) return 0;
		int count = 1;

		for(int i = 0; i < s.length() - 1; i++) {
			int num1 = s.charAt(i) - '0';
			int num2 = s.charAt(i + 1) - '0';
			
			int num3 = num1 * 10 + num2;
			
			if(num3 <= 26)
				count++;
			
		}

		return count;
	}

}
