package card_flipping_game_822;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		System.out.println(flipgame(new int[] { 1, 2, 4, 4, 7 }, new int[] { 1, 3, 4, 1, 3 }));
		System.out.println(flipgame(new int[] { 1, 1 }, new int[] { 1, 3 }));
		System.out.println(flipgame(new int[] { 1, 2 }, new int[] { 1, 1 }));
		System.out.println(flipgame(new int[] { 1, 2 }, new int[] { 2, 1 }));
	}

	public static int flipgame(int[] fronts, int[] backs) {

		Set<Integer> set = new HashSet<>();

		Set<Integer> intersection = new HashSet<>();

		for (int i = 0; i < fronts.length; i++)
			set.add(fronts[i]);

		for (int i = 0; i < backs.length; i++)
			set.add(backs[i]);

		for (int i = 0; i < fronts.length; i++)
			if (fronts[i] == backs[i])
				intersection.add(fronts[i]);


		for(Integer itr : set) 
			if(!intersection.contains(itr)) return itr;
		
		return 0;

	}

}
