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
	 * @param index 从哪个点开始出发
	 */
	public void dsj(int index) {
		visitedCity = new VisitedCity(city, index);
		update(index);
		for(int j =1; j< city.length;j++) {
			index = visitedCity.next();//选择下个节点
			update(index);
		}
		
	}
	
	private void update(int index) {
		int len = 0;
		for (int i = 0; i < distance[index].length; i++) {
			len =visitedCity.getDis(index) + distance[index][i];
			//如果当前i这个节点还没有访问过 
			//或者从index到i的距离更近
			if( !visitedCity.in(i) && len<visitedCity.getDis(i)) {
				visitedCity.updateDistance(i, len);
				visitedCity.updateParent(i, index);
			}
		}
	}
	
	
	
	
	
	
	
}
