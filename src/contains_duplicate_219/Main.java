package contains_duplicate_219;

import java.util.HashMap;

public class Main {
	
	public static void main(String args[]) {
		
		int arr[] = {1,2,3,1};
		System.out.println(containsNearbyDuplicate(arr, 3));
		int arr_[] = {1,0,1,1};
		System.out.println(containsNearbyDuplicate(arr_, 1));
		int arr__[] = {1,2,3,1,2,3};
		System.out.println(containsNearbyDuplicate(arr__, 2));
		
	}
	
	public static boolean containsNearbyDuplicate(int []nums, int k) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			
			if(map.containsKey(nums[i])) {
				int temp = map.get(nums[i]);
				if(Math.abs(temp - i) <= k) 
					return true;
				map.replace(nums[i], i);
			}
			else map.put(nums[i], i);
			
		}
		
		return false;
	}
	
}
