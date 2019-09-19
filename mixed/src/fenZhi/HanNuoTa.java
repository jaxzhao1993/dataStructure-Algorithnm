package fenZhi;

public class HanNuoTa {
	
	//汉诺塔移动方法h
	/**
	 * @param number
	 * @param a 从A塔开始移动
	 * @param b 中间借助B 塔
	 * @param c 移动到C塔
	 */
	public static void hanoiTower(int number, char a, char b, char c) {
		if (number ==1) {
			System.out.println("第1个盘 "+a +"->" + c);
		}else {
			
			hanoiTower(number-1, a, c, b);
			System.out.println("第" + number+ "个盘 " + a +"->" +c);
			hanoiTower(number-1, b, a, c);
		}
	}
	
}
