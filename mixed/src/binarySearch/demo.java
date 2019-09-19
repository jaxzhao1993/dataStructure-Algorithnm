package binarySearch;

import java.util.List;

public class demo {
	public static void main(String[] args) {
		int[] array2 = {1,3,5,5,5,5,5,5,89,89};
		List<Integer> result = BinarySearch.binarySearch(array2, 5);
		System.out.println(result);
	}
	
}
