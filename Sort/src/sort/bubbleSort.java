package sort;

import java.util.Arrays;

public class bubbleSort {
	//ʱ�临�Ӷ� O��n^2��
	public static void bubble(int[] array) {
		int temp=0;
		//��ǣ����һ����������������û�з���������˵���Ѿ������˳�ѭ��
		boolean flag= false;
		//ÿһ�ִӵ�һ��Ԫ�ؿ�ʼ
		for (int i = 0; i < array.length-1; i++) {
			//�Ƚ�ÿ��������Ԫ�صĴ�С
			for (int j = 0; j<array.length-1-i; j++) {
				if(array[j]>array[j+1])
				{	flag =true;
					temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					}
			}
//			System.out.println("��"+i+"�������");
//			System.out.println(Arrays.toString(array));
			
			if(flag== false)
			{
				break;
			}else {
				flag=false;
			}
		}
	}
}
