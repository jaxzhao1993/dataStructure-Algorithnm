package sort;

import java.util.Arrays;

public class SelectSort {
	/*
	 * 思想， 第一次从 a[0]到a[length-1] 选取最小值，并与a[0]交换
	 * 	     每次从后面数据中找最小，并与a[i]交换
	 */
	public static void selSort(int[] array) {
		int temp = 0;
		int index;
		for (int i = 0; i < array.length-1; i++) {
			//从a[i]到a[length-1]找到最小值，并与a[i]交换
			index = i;
			for (int j = i; j < array.length; j++) {
				if (array[j]<array[index]) {
					index = j;
				}
			}
			
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
		System.out.println(Arrays.toString(array));
	}
}
