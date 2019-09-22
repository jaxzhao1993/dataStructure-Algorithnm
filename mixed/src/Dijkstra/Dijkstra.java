package Dijkstra;

import java.util.Arrays;

public class Dijkstra {
	private char[] city;
	private int[][] distance;
	private VisitedCity visitedCity;
	
	public Dijkstra(char[] vertex, int[][] matrix)
	{
		city = vertex;
		distance = matrix;
	}
	
	public void show() {
//		for (int[] link : distance) {
//			System.out.println(Arrays.toString(link));
//		}
		visitedCity.show();
	}
	
	/**
	 * @param index ���ĸ��㿪ʼ����
	 */
	public void dsj(int index) {
		visitedCity = new VisitedCity(city, index);
		update(index);
		for(int j =1; j< city.length;j++) {
			index = visitedCity.next();//ѡ���¸��ڵ�
			update(index);
		}
		
	}
	
	private void update(int index) {
		int len = 0;
		for (int i = 0; i < distance[index].length; i++) {
			len =visitedCity.getDis(index) + distance[index][i];
			//�����ǰi����ڵ㻹û�з��ʹ� 
			//���ߴ�index��i�ľ������
			if( !visitedCity.in(i) && len<visitedCity.getDis(i)) {
				visitedCity.updateDistance(i, len);
				visitedCity.updateParent(i, index);
			}
		}
	}
	
	
	
	
	
	
	
}
