package reveres_String_II_541;

public class Main {

	public static void main(String args[]) {

		String str = "abcdefghijkl";
		int k = 4;
		
		System.out.println(solution(str, k));

	}
	
	public static String reveres(String temp, int k) {
		
		char []hand = temp.toCharArray();
		for(int i=0, j=k-1; i<=j; i++,j--) {
			char a = hand[i];
			hand [i] = hand[j];
			hand[j] = a;
		}
		temp = String.valueOf(hand);
		return temp;
	}
	
	public static String solution(String str, int k) {
		
		if(k == 0) {
			return str;
		}
		
		char hand[] = str.toCharArray();
		
		int k_2 = 2*k;

		int n = str.length();
		
		int m = 0;
		
		for(int i=0; i<n; i++) {
			
			if(str.length() - m >= k_2-1) {
				
				String temp = str.substring(m, m+k_2-1);
				temp = reveres(temp, k);

				for(int j=0; j<k; j++) {
					m++;
					hand[i + j] = temp.charAt(j);
				}
				//i = i + k_2 - 1;
			}
			else if((n-m<k_2) && (m==k)) {
								
				String temp = str.substring(m, str.length());
				//System.out.println(temp);
				temp  = reveres(temp, k);
				int j =0;
				for(j=0; j<k; j++) {
					hand[m + j] = temp.charAt(j);
				}
				m = m + j;
			}
			else if(str.length() - m < k) {
				String temp = str.substring(m,str.length());
				//System.out.println(temp);
				temp = reveres(temp, temp.length());
				int j =0;
				for(j=0; j<temp.length(); j++) {
					hand[m + j] = temp.charAt(j);
				}
				m = m + j;
			}
			i = i + m - 1;
		}
		
		String ans = String.valueOf(hand);
		
		return ans;
	}
	
}
