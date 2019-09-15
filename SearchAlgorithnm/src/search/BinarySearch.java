package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
//		int[] array = {1,3,5,34,64,89};
//		int index = binarySearch(array, 0, array.length-1, 61);
//		System.out.println(index);
		
		int[] array2 = {1,3,5,5,5,5,5,5,64,89};
		ArrayList<Integer> list = binarySearch2(array2, 0, array2.length-1, 89);
		System.out.println(list);
	}
	
	/**前提是数组有序
	 * 结束条件为low > hi 退出
	 * 
	 * 使用递归
	 */
	public static int binarySearch(int array[], int low, int hi, int value) {
		int mid = (low+hi)/2;
		if(low > hi)
		{
			return -1;
		}
		if (value< array[mid]) {
			return binarySearch(array, low, mid-1, value);
		} 
		else if (value> array[mid]) 
		{
			return binarySearch(array, mid+1, hi, value);
		} 
		else{
			return mid;
		}

	}

	
	
	/**为了能够找到所有的元素当找到下标的时候，不着急返回
		向mid索引左右两边扫描
	 */
	public static ArrayList binarySearch2(int array[], int low, int hi, int value) {
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		int mid = (low+hi)>>1;
		if(low > hi)
		{
			return indexList;
		}
		if (value< array[mid]) {
			return binarySearch2(array, low, mid-1, value);
		} 
		else if (value> array[mid]) 
		{
			return binarySearch2(array, mid+1, hi, value);
		} 
		else{
			
			int temp = mid-1;
			while(true)
			{
				if (temp<0 || array[temp]!=value) {
					break;
				}else {
					indexList.add(temp);
					temp--;
				}
			}
			indexList.add(mid);
			temp = mid+1;
			while(true)
			{
				if (temp>array.length-1 || array[temp]!=value) {
					break;
				}else {
					indexList.add(temp);
					temp++;
				}
			}
			return indexList;
		}

	}




}
