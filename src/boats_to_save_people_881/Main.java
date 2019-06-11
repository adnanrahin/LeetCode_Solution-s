package boats_to_save_people_881;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

		System.out.println(numRescueBoats(new int[] { 3, 2, 2, 1 }, 3)); // 3
		System.out.println(numRescueBoats(new int[] { 3, 3, 4, 5 }, 5)); // 4
		System.out.println(numRescueBoats(new int[] { 1, 2 }, 3)); // 1
		System.out.println(numRescueBoats(new int[] { 2, 3, 4, 7, 6 }, 6)); // 4
		System.out.println(numRescueBoats(new int[] { 2, 3, 4, 7, 2 }, 6)); // 3
	}

	public static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int j = people.length - 1;
		for (int i = 0; i <= j; --j)
			if (people[i] + people[j] <= limit)
				i++;

		return people.length - 1 - j;
	}

}
