package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	//Ä¬ÈÏÊı×éÉıĞò
		public static List<Integer> binarySearch(int[] array, int target) {
			List<Integer> result = new ArrayList<Integer>();
			int left = 0;
			int right = array.length-1;
			while(left<=right) {
				int mid = (left+right)>>1;
				if (array[mid] == target) {
					result.add(mid);
					int temp1 =mid -1;
					while ( temp1>0 &&array[temp1] == target) {
						result.add(temp1);
						temp1-=1;
					}
					int temp2= mid +1;
					while (temp2<array.length && array[temp2]==target) {
						result.add(temp2);
						temp2+=1;
					}
					return result;
				}else if (array[mid]>target) {
					right =mid-1;
				}else {
					left = mid+1;
				}
			}
			return result;
		}
}
