package search;

import java.util.ArrayList;
import java.util.Arrays;

public class GapSearch {
	public static void main(String[] args) {
		int[] array = new int[100];
		for(int i=0; i<100;i++)
		{
			array[i]= i+1;
		}
		System.out.println(Arrays.toString(array));
		
		ArrayList<Integer> list = insertSearch(array, 0, array.length-1, 100);
		System.out.println(list);
		
	}



public static ArrayList insertSearch(int array[], int low, int hi, int value) {
	ArrayList<Integer> indexList = new ArrayList<Integer>();
	
	//一定要加上判断，否则mid可能越界
	if(low > hi || value < array[0] || value > array[array.length-1])
	{
		return indexList;
	}
	int mid = low + (hi-low)*(value-array[low])/(array[hi]-array[low]);
	if (value< array[mid]) {
		return insertSearch(array, low, mid-1, value);
	} 
	else if (value> array[mid]) 
	{
		return insertSearch(array, mid+1, hi, value);
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