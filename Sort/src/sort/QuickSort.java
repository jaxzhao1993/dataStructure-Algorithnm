package sort;


public class QuickSort {
	
	
	public static void quickSort(int[] array, int left, int right) {
		int lo = left; //���±�
		int hi = right;//���±�
		int temp = 0;
		int pivotIndex = ( lo + hi ) / 2;
		int pivot = array[pivotIndex];
		// �Ȼ���С��ֵ�ŵ���ߣ��Ȼ������ֵ�������ұ�
		while(lo<hi)
		{
			//��pivot����ҵ�һ��>=pivot��ֵ
			while(array[lo]<pivot)
			{
				lo=lo+1;
			}
			//��pivot����ҵ�һ��<=pivot��ֵ
			while(array[hi]>pivot)
			{
				hi=hi-1;
			}
			//˵��pivot�������ߵ�ֵ�Ѿ��ֺ���
			if(lo>= hi)
			{
				break;
			}
			temp = array[lo];
			array[lo] = array[hi];
			array[hi] = temp;
			//�����������ͬԪ�أ���������ѭ��
			// ��Ϊ����array[lo] ��ʵ�ǽ���֮ǰarray[hi]
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
