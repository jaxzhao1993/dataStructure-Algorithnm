package sort;

import java.util.Arrays;

public class SelectSort {
	/*
	 * ˼�룬 ��һ�δ� a[0]��a[length-1] ѡȡ��Сֵ������a[0]����
	 * 	     ÿ�δӺ�������������С������a[i]����
	 */
	public static void selSort(int[] array) {
		int temp = 0;
		int index;
		for (int i = 0; i < array.length-1; i++) {
			//��a[i]��a[length-1]�ҵ���Сֵ������a[i]����
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
