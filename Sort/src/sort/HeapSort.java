package sort;

import java.util.Arrays;

public class HeapSort {
	/*
	 * ������Ļ���˼�룺
	 * 1.���������鹹���һ���󶥶ѣ�����󶥶ѣ�����С���ѣ�
	 * 2.��ʱ���������е����ֵ���ǶѶ��ĸ��ڵ�
	 * 3.������ĩβԪ�ؽ���
	 * 4��ʣ��n-1��Ԫ�����¹���ɶ�
	 */
	
	public static void main(String[] args) {
		int[] array = {4,6,8,5,9};
		heapSort(array);
	}
	
	public static void heapSort(int[] array) {
		System.out.println("������");
		int temp = 0;
		for (int i = array.length/2-1; i >=0; i--) {
			adjustHeap(array, i, array.length);
		}
		//System.out.println("��һ��" + Arrays.toString(array));
		
		for(int j =array.length-1; j>0; j--) {
			//����
			temp = array[j];
			array[j] = array[0];
			array[0] = temp;
			adjustHeap(array, 0, j);
		}
		//System.out.println(Arrays.toString(array));
		//�ֲ���֤
//		adjustHeap(array, 1, array.length);
//		System.out.println("��һ��");
//		System.out.println(Arrays.toString(array));
//		adjustHeap(array, 0, array.length);
//		System.out.println("�ڶ���");
//		System.out.println(Arrays.toString(array));
		
	}
	//��һ�����飨��������������һ�Ŵ󶥶�
	/**
	 * @param array ������������
	 * @param length �Զ��ٸ�Ԫ�ؽ��е�����length�����𽥼���
	 * @param i ��ʾ��Ҷ�ӽڵ� ������������
	 * 
	 * int[] array ={4,6,8,5,9} int i =1 >>>>>> �õ�[4,9,8,5,6] i =0 >>>>[9,4,8,5,6]
	 * 
	 */
	public static void adjustHeap(int[] array, int i, int length) {
		int temp = array[i];//ȡ����ǰԪ�ص�ֵ
		//��ʼ����
		for (int k=2*i+1; k<length; k=2*k+1) {
			//�ҵ�i��Ӧ�����ӽڵ�
			if (k+1< length && array[k]<array[k+1]) {
				//������ӽڵ�󣬾��ҵ����ӽڵ�
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
