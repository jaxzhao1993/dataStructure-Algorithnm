package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = {8,4,5,7,1,3,6,2};
		int[] temp = new int[array.length];
		//System.out.println(array.length-1);
		mergeSort(array, 0, array.length-1, temp);
		System.out.println("���κ�"+ Arrays.toString(array));
	}
	
	public static void mergeSort(int[] array, int left, int right, int[] temp) {
		if(left<right)
		{
			int mid = (left+right)/2; //�м�����
			mergeSort(array, left, mid, temp);//����ݹ�
			mergeSort(array, mid+1, right, temp);//���ҵݹ�
			merge(array, left, right, mid, temp);
		}
	}
	
	
	/**
	 * @param array ��Ҫ�����ԭʼ����
	 * @param left ����������еĳ�ʼ����
	 * @param right
	 * @param mid
	 * @param temp ��ʱ����
	 */
	public static void merge(int[] array, int left, int right, int mid, int[] temp) {
		//System.out.println(Arrays.toString(temp));
		int i =left;  //����������еĳ�ʼ����
		int j = mid + 1;//�ұ��������еĳ�ʼ����
		int tempIndex = 0;
		
		//�Ȱ��������ߵ����ݣ����չ�����䵽temp����
		//ֱ����һ�ߴ������Ϊֹ
		while(i<= mid && j<=right)
		{	//���������ߵ��������� С�ڵ��� �ұߵĵ�ǰԪ��
			if (array[i]<= array[j]) 
			{
				temp[tempIndex] = array[i];
				i+=1;
				tempIndex+=1;
			}else {
				temp[tempIndex] = array[j];
				j+=1;
				tempIndex+=1;
			}
			
		} 
		//����ʣ�����ݵ�һ��������һ��ȫ����䵽temp
		//�����߻���ʣ��
		while(i<=mid)
		{
			temp[tempIndex]=array[i];
			i++;
			tempIndex++;
		}
		//����ұ߻���ʣ��
		while(j<=right)
		{
			temp[tempIndex]=array[j];
			j++;
			tempIndex++;
		}
		//��temp�������¿�����array
		tempIndex =0;
		int templeft = left;
		//System.out.println("LEFT: "+ templeft + " right"+ right);
		while(templeft<=right)
		{
			array[templeft] = temp[tempIndex];
			templeft++;
			tempIndex++;
		}
	}
}
