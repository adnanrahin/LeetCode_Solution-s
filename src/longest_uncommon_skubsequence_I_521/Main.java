package longest_uncommon_skubsequence_I_521;

public class Main {

	public static void main(String args[]) {
		System.out.println(findLUSlength("aba", "cdc"));
		System.out.println(findLUSlength("bbsdafas", "fsdfafd"));
	}

	public static int findLUSlength(String a, String b) {

		if (a.equals(b))
			return -1;
		return Math.max(a.length(), b.length());

	}

}
