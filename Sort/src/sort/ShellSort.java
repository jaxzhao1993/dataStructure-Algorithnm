package sort;

import java.util.Arrays;

public class ShellSort {
	
	
	public static void shellSort(int[] array){
		//shell���򣬽����ݰ��ղ����ֳ� length / 2  ��,��2������һ��
		//ÿ�����ݷ���/2��ÿ�����ݱ��
		int temp =0;
		for(int gap = array.length/2; gap>0; gap = gap/2)
		{	
			for (int i = gap; i < array.length; i=i++)
			{
				for (int j = i-gap; j >=0; j=j-gap) 
				{
					if (array[j]> array[j+gap]) 
					{	
						temp =array[j] ;
						array[j] = array[j+gap];
						array[j+gap]= temp;
						//swap(array[j], array[j+gap]);
					}
				}		
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void shellSort2(int[] array) {
		//���ڽ���ʽ�ķ������ں�ʱ
		//���Բ�����λ��
		for (int gap=array.length/2; gap>0; gap=gap/2) {
			//��gap��Ԫ�ؿ�ʼ���������������в�������
			for (int i = gap; i < array.length; i++) {
				int insertValue = array[i]; //�������ֵ
				int insertIndex = i; //��������±�
				if (array[i] < array[i-gap]) {
					//���в�������
					while(insertIndex-gap>=0 && insertValue < array[insertIndex-gap])
					{
						array[insertIndex]= array[insertIndex-gap];
						insertIndex = insertIndex -gap;
					}
					    array[insertIndex] = insertValue;
				}
			}
		}
	}
	
}
