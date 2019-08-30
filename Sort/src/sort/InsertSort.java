package sort;

import java.util.Arrays;

public class InsertSort {
	public static void insertSort(int[] array) {
		int insertIndex, insertValue;		
		//从a[1]个元素开始往前插
		for (int i = 1; i < array.length; i++) {
			//插到哪里呢
			//范围0-i
			insertIndex = i-1;
			insertValue = array[i];
			while(insertIndex>=0 && insertValue < array[insertIndex] )
			{
				array[insertIndex+1] =array[insertIndex];
				insertIndex--;
			}//当退出while循环时,说明插入位置是index+1
				array[insertIndex+1] = insertValue;

		}
		System.out.println(Arrays.toString(array));
		
		
		
	}
}