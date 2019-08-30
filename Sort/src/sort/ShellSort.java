package sort;

import java.util.Arrays;

public class ShellSort {
	
	
	public static void shellSort(int[] array){
		//shell排序，将数据安照步长分成 length / 2  组,，2个数据一组
		//每次数据分组/2，每组数据变多
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
		//由于交换式的方法过于耗时
		//所以采用移位法
		for (int gap=array.length/2; gap>0; gap=gap/2) {
			//从gap个元素开始，逐个对所在组进行插入排序
			for (int i = gap; i < array.length; i++) {
				int insertValue = array[i]; //待插入的值
				int insertIndex = i; //待插入的下标
				if (array[i] < array[i-gap]) {
					//进行插入排序
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
