package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class demo {
	public static void main(String[] args) {
		int[] array = new int[80000];
		for (int i = 0; i < 80000; i++) {
			array[i] = (int)(Math.random()*8000000);
		}
		
		int[] array2 = {-1,5,3,-10,8};
//		Date date1 = new Date();
//		SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//		String dateString = simpleDateFormat.format(date1);
//		System.out.println("排序前:" +dateString);
		long startTime=System.currentTimeMillis();
		
		SelectSort.selSort(array);
	//	bubbleSort.bubble(array); //80000个数据排序，大约1W 毫秒
		
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");  
		
		
//		Date date2 = new Date();
//		String date2String = simpleDateFormat.format(date2);
//		System.out.println("排序后:" +date2String);
	}
	
}
