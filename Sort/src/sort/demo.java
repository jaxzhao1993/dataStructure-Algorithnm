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
//		System.out.println("����ǰ:" +dateString);
		long startTime=System.currentTimeMillis();
		
		SelectSort.selSort(array);
	//	bubbleSort.bubble(array); //80000���������򣬴�Լ1W ����
		
		long endTime=System.currentTimeMillis();
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");  
		
		
//		Date date2 = new Date();
//		String date2String = simpleDateFormat.format(date2);
//		System.out.println("�����:" +date2String);
	}
	
}
