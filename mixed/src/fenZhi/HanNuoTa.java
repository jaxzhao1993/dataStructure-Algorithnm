package fenZhi;

public class HanNuoTa {
	
	//��ŵ���ƶ�����h
	/**
	 * @param number
	 * @param a ��A����ʼ�ƶ�
	 * @param b �м����B ��
	 * @param c �ƶ���C��
	 */
	public static void hanoiTower(int number, char a, char b, char c) {
		if (number ==1) {
			System.out.println("��1���� "+a +"->" + c);
		}else {
			
			hanoiTower(number-1, a, c, b);
			System.out.println("��" + number+ "���� " + a +"->" +c);
			hanoiTower(number-1, b, a, c);
		}
	}
	
}
