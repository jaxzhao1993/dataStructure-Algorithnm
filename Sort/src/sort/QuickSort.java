package sort;


public class QuickSort {
	
	
	public static void quickSort(int[] array, int left, int right) {
		int lo = left; //左下标
		int hi = right;//右下标
		int temp = 0;
		int pivotIndex = ( lo + hi ) / 2;
		int pivot = array[pivotIndex];
		// 比基数小的值放到左边，比基数大的值，放在右边
		while(lo<hi)
		{
			//在pivot左边找到一个>=pivot的值
			while(array[lo]<pivot)
			{
				lo=lo+1;
			}
			//在pivot左边找到一个<=pivot的值
			while(array[hi]>pivot)
			{
				hi=hi-1;
			}
			//说明pivot左右两边的值已经分好了
			if(lo>= hi)
			{
				break;
			}
			temp = array[lo];
			array[lo] = array[hi];
			array[hi] = temp;
			//如果数组有相同元素，会陷入死循环
			// 因为这是array[lo] 其实是交换之前array[hi]
			if (array[lo] == pivot) {
				hi = hi-1;
			}if (array[hi] == pivot) {
				lo = lo + 1;
			}
		}
		if (hi == lo) {
			lo++;
			hi--;
		}if (left< hi) 
		{
			quickSort(array, left, hi);
			
		}
        if(right > lo)
		{
			quickSort(array, lo, right);
		}
	}
	
}
