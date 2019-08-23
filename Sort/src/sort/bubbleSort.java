package sort;

import java.util.Arrays;

public class bubbleSort {
	//时间复杂度 O（n^2）
	public static void bubble(int[] array) {
		int temp=0;
		//标记，如果一轮排序下来，发现没有发生交换，说明已经有序，退出循环
		boolean flag= false;
		//每一轮从第一个元素开始
		for (int i = 0; i < array.length-1; i++) {
			//比较每两个相邻元素的大小
			for (int j = 0; j<array.length-1-i; j++) {
				if(array[j]>array[j+1])
				{	flag =true;
					temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					}
			}
//			System.out.println("第"+i+"轮排序后");
//			System.out.println(Arrays.toString(array));
			
			if(flag== false)
			{
				break;
			}else {
				flag=false;
			}
		}
	}
}
