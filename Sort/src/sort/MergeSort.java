package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = {8,4,5,7,1,3,6,2};
		int[] temp = new int[array.length];
		//System.out.println(array.length-1);
		mergeSort(array, 0, array.length-1, temp);
		System.out.println("分治后："+ Arrays.toString(array));
	}
	
	public static void mergeSort(int[] array, int left, int right, int[] temp) {
		if(left<right)
		{
			int mid = (left+right)/2; //中间索引
			mergeSort(array, left, mid, temp);//向左递归
			mergeSort(array, mid+1, right, temp);//向右递归
			merge(array, left, right, mid, temp);
		}
	}
	
	
	/**
	 * @param array 需要排序的原始数组
	 * @param left 左边有序序列的初始索引
	 * @param right
	 * @param mid
	 * @param temp 临时数组
	 */
	public static void merge(int[] array, int left, int right, int mid, int[] temp) {
		//System.out.println(Arrays.toString(temp));
		int i =left;  //左边有序序列的初始索引
		int j = mid + 1;//右边有序序列的初始索引
		int tempIndex = 0;
		
		//先把左右两边的数据，按照规则填充到temp数组
		//直到有一边处理完毕为止
		while(i<= mid && j<=right)
		{	//如果发现左边的有序序列 小于等于 右边的当前元素
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
		//把有剩余数据的一方的数据一次全部填充到temp
		//如果左边还有剩余
		while(i<=mid)
		{
			temp[tempIndex]=array[i];
			i++;
			tempIndex++;
		}
		//如果右边还有剩余
		while(j<=right)
		{
			temp[tempIndex]=array[j];
			j++;
			tempIndex++;
		}
		//将temp数据重新拷贝到array
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
