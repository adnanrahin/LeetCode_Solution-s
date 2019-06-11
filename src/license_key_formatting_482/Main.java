package license_key_formatting_482;

public class Main {

	public static void main(String args[]) {

		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(licenseKeyFormatting("2-5g-3-J", 2));

	}

	public static String licenseKeyFormatting(String S, int K) {

		StringBuffer sBuffer = new StringBuffer();
		S = S.toUpperCase();

		S = S.replace("-", "");

		sBuffer = new StringBuffer(S);

		sBuffer.reverse();

		S = new String(sBuffer);

		sBuffer = new StringBuffer();

		for (int i = S.length() - 1; i >= 0; i--) {

			if ((i+1) % K == 0 && i != S.length() - 1) {
				sBuffer.append("-");
				sBuffer.append(S.charAt(i));
				
			} else
				sBuffer.append(S.charAt(i));

		}

		return sBuffer.toString();

	}

}
