package sort;

import java.util.Arrays;

public class InsertSort {
	public static void insertSort(int[] array) {
		int insertIndex, insertValue;		
		//��a[1]��Ԫ�ؿ�ʼ��ǰ��
		for (int i = 1; i < array.length; i++) {
			//�嵽������
			//��Χ0-i
			insertIndex = i-1;
			insertValue = array[i];
			while(insertIndex>=0 && insertValue < array[insertIndex] )
			{
				array[insertIndex+1] =array[insertIndex];
				insertIndex--;
			}//���˳�whileѭ��ʱ,˵������λ����index+1
				array[insertIndex+1] = insertValue;

		}
		System.out.println(Arrays.toString(array));
		
		
		
	}
}