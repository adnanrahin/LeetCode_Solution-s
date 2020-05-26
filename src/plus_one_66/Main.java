package plus_one_66;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String args[]) {
		
		System.out.println(plusOne(new int [] {9,9,9,9,9}));
		
	}
	
	public static int[] plusOne(int[] digits) {
		
		List<Integer> primary = new ArrayList<>();
		
		digits[digits.length - 1] += 1;
		
		for (int i = digits.length - 1; i >= 1; i--) {

			if(digits[i] > 9) {
				
				int mod = digits[i] % 10;
				digits[i - 1] += digits[i] / 10;
				primary.add(mod);
			}else primary.add(digits[i]);

		}
		
		if(digits[0] > 9) {
			primary.add(digits[0] % 10);
			primary.add(digits[0] / 10);
		}else primary.add(digits[0]);
		
		
		int []ans = new int[primary.size()];
		
		for(int i = primary.size() - 1, j = 0; i >= 0; i--) {
			ans[j++] = primary.get(i);
		}
		
		return ans;
	}
	
}
