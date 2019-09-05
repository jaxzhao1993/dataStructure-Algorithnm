package sort;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] array = {53,3,542,748,14,214};
		radixSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void radixSort(int[] array) {
		//����1����ά���飬��ʾ10��Ͱ
		//Ϊ�˷�ֹ����������ռ任ʱ��
		int[][] bucket = new int[10][array.length];
		//ÿ��Ͱ��Ҫ��¼�м�����Ч���ݣ���һά��������¼
		int[] bucketCounts = new int[10];
		
		//Ϊ��ȷ��ѭ�����������ҵ�������
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if(array[i]> max)
			{
				max = array[i];
			}
		}
		
		int max_length = (max+"").length();
		
		for(int k=0, n=1; k<max_length;k++,n*=10)
		{
			for (int i = 0; i < array.length; i++) {
				//ȡ��ÿ��Ԫ�صĸ�λ��
				int element = array[i] /n %10;
				bucket[element][bucketCounts[element]] = array[i];
				bucketCounts[element]++; //��¼����++
			}
			//Ͱ����ȡ�������Ż�����
			int index= 0;
				for (int i = 0; i < bucket.length; i++) {
					//�鿴Ͱ���Ƿ�������
					if (bucketCounts[i]!=0 ) {
						for (int j=0; j< bucketCounts[i]; j++) {
							array[index] = bucket[i][j];
							index++;
						}
					}
					bucketCounts[i]=0;
				}
		//		System.out.println("��"+k+1 +"�ֺ�Ľ����:" + Arrays.toString(array));
		}
		
		
	}
}

