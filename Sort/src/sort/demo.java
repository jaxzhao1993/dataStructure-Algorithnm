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
//		System.out.println("����ǰ:" +dateString);
		long startTime=System.currentTimeMillis();
//		System.out.println(Arrays.toString(array));
		RadixSort.radixSort(array);  //8���������, 500ms //��8000������ݺ󣬻�����ڴ治��
	//	MergeSort.mergeSort(array, 0, array.length-1, temp);//80000���������򣬴�Լ20 ����
	//	QuickSort.quickSort(array, 0, array.length-1);//80000���������򣬴�Լ20 ���� 8���������, 1000ms
	//	System.out.println(Arrays.toString(array));
	//	ShellSort.shellSort2(array);//80000���������򣬴�Լ25 ����    8���������, 2072ms
	//	ShellSort.shellSort(array);//80000���������򣬴�Լ 6000 ����
	//  InsertSort.insertSort(array);//80000���������򣬴�Լ 4500 ����
		
	//	SelectSort.selSort(array);//80000���������򣬴�Լ 2200 ����
	//	bubbleSort.bubble(array); //80000���������򣬴�Լ10000 ����
		
		long endTime=System.currentTimeMillis();
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");  
		
		
//		Date date2 = new Date();
//		String date2String = simpleDateFormat.format(date2);
//		System.out.println("�����:" +date2String);
	}
	
}
