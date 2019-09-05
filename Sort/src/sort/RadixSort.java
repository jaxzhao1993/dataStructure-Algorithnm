package sort;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] array = {53,3,542,748,14,214};
		radixSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void radixSort(int[] array) {
		//定义1个二维数组，表示10个桶
		//为了防止数据溢出，空间换时间
		int[][] bucket = new int[10][array.length];
		//每个桶需要记录有几个有效数据，用一维数据来记录
		int[] bucketCounts = new int[10];
		
		//为了确定循环次数，先找到最大的数
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
				//取出每个元素的个位数
				int element = array[i] /n %10;
				bucket[element][bucketCounts[element]] = array[i];
				bucketCounts[element]++; //记录数据++
			}
			//桶数据取出，并放回数组
			int index= 0;
				for (int i = 0; i < bucket.length; i++) {
					//查看桶里是否有数据
					if (bucketCounts[i]!=0 ) {
						for (int j=0; j< bucketCounts[i]; j++) {
							array[index] = bucket[i][j];
							index++;
						}
					}
					bucketCounts[i]=0;
				}
		//		System.out.println("第"+k+1 +"轮后的结果是:" + Arrays.toString(array));
		}
		
		
	}
}

