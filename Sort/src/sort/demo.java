package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class demo {
	public static void main(String[] args) {
		int[] array = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			array[i] = (int)(Math.random()*8000000);
		}
		int[] temp = new int[array.length];
		int[] array2 = {-1,8,5,7,6,3,10,8};
//		Date date1 = new Date();
//		SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//		String dateString = simpleDateFormat.format(date1);
//		System.out.println("排序前:" +dateString);
		long startTime=System.currentTimeMillis();
//		System.out.println(Arrays.toString(array));
		RadixSort.radixSort(array);  //8百万个数据, 500ms //当8000万个数据后，会出现内存不足
	//	MergeSort.mergeSort(array, 0, array.length-1, temp);//80000个数据排序，大约20 毫秒
	//	QuickSort.quickSort(array, 0, array.length-1);//80000个数据排序，大约20 毫秒 8百万个数据, 1000ms
	//	System.out.println(Arrays.toString(array));
	//	ShellSort.shellSort2(array);//80000个数据排序，大约25 毫秒    8百万个数据, 2072ms
	//	ShellSort.shellSort(array);//80000个数据排序，大约 6000 毫秒
	//  InsertSort.insertSort(array);//80000个数据排序，大约 4500 毫秒
		
	//	SelectSort.selSort(array);//80000个数据排序，大约 2200 毫秒
	//	bubbleSort.bubble(array); //80000个数据排序，大约10000 毫秒
		
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");  
		
		
//		Date date2 = new Date();
//		String date2String = simpleDateFormat.format(date2);
//		System.out.println("排序后:" +date2String);
	}
	
}
