package sort;

import java.util.Arrays;

public class HeapSort {
	/*
	 * 堆排序的基本思想：
	 * 1.将无序数组构造成一个大顶堆（升序大顶堆，降序小顶堆）
	 * 2.此时，整个序列的最大值就是堆顶的根节点
	 * 3.将其与末尾元素交换
	 * 4将剩余n-1个元素重新构造成堆
	 */
	
	public static void main(String[] args) {
		int[] array = {4,6,8,5,9};
		heapSort(array);
	}
	
	public static void heapSort(int[] array) {
		System.out.println("堆排序");
		int temp = 0;
		for (int i = array.length/2-1; i >=0; i--) {
			adjustHeap(array, i, array.length);
		}
		//System.out.println("第一次" + Arrays.toString(array));
		
		for(int j =array.length-1; j>0; j--) {
			//交换
			temp = array[j];
			array[j] = array[0];
			array[0] = temp;
			adjustHeap(array, 0, j);
		}
		//System.out.println(Arrays.toString(array));
		//分步验证
//		adjustHeap(array, 1, array.length);
//		System.out.println("第一次");
//		System.out.println(Arrays.toString(array));
//		adjustHeap(array, 0, array.length);
//		System.out.println("第二次");
//		System.out.println(Arrays.toString(array));
		
	}
	//将一个数组（二叉树）调整成一颗大顶堆
	/**
	 * @param array 待调整的数组
	 * @param length 对多少个元素进行调整，length是在逐渐减少
	 * @param i 表示非叶子节点 在数组中索引
	 * 
	 * int[] array ={4,6,8,5,9} int i =1 >>>>>> 得到[4,9,8,5,6] i =0 >>>>[9,4,8,5,6]
	 * 
	 */
	public static void adjustHeap(int[] array, int i, int length) {
		int temp = array[i];//取出当前元素的值
		//开始调整
		for (int k=2*i+1; k<length; k=2*k+1) {
			//找到i对应的左子节点
			if (k+1< length && array[k]<array[k+1]) {
				//如果右子节点大，就找到右子节点
				k++;
			}
			if (array[k]> temp) {
				array[i]= array[k];
				i=k;
			}else {
				break;
			}
		}
		array[i] = temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
