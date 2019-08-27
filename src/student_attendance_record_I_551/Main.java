package student_attendance_record_I_551;

public class Main {

	public static void main(String args[]) {

		System.out.println(checkRecord("PAPLLPLL"));
		System.out.println(checkRecord("PAPLLPLLL"));

	}

	public static boolean checkRecord(String s) {
		
		int aCounter = 0;
		int lCounterLocal = 0;
		int lCounterGlobal = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				aCounter++;
			}
			if (s.charAt(i) == 'L') {
				lCounterLocal++;
				if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
					continue;
				} else {
					lCounterGlobal = Math.max(lCounterGlobal, lCounterLocal);
					lCounterLocal = 0;
				}
			}
		}

		if (aCounter > 1)
			return false;
		if (lCounterGlobal > 2)
			return false;

		return true;
	}

}
