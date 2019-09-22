package Dijkstra;

import java.util.Arrays;
import java.util.List;

public class VisitedCity {
	public boolean[] visited;
	public int[] parent;
	public int[] distance;
	
	/**
	 * @param city
	 * @param index ��ʾ��������
	 */
	public VisitedCity(char[] city, int index) {
		this.visited = new boolean[city.length];
		this.parent = new int[city.length];
		this.distance = new int[city.length];
		//��ʼ��dis����
		Arrays.fill(distance, 65535);
		distance[index] = 0;
		visited[index] =true;
	}
	

	//�ж�index �����Ƿ񱻷��ʹ�
	public boolean in(int index) {
		return visited[index];
	}
	
	/** ���³������㵽index�ľ���
	 * @param index
	 * @param minDis
	 */
	public void updateDistance(int index, int minDis) {
		distance[index] = minDis;
	}
	
	public void updateParent(int index, int pre) {
		parent[index] = pre;
	}
	
	//���س����㵽index�ľ���
	public int getDis(int index) {
		return distance[index];
	}
	
	//�ӻ�û���ʹ��Ľڵ��У�ѡ���뵱ǰ�ڵ����������Ǹ��ڵ�
	public int next() {
		int min = 65535, index=0;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]==false && distance[i]< min) {
				min = distance[i];
				index = i;
			}
		}
		visited[index] =true;
		return index;
	}
	
	public void show() {
		System.out.println("===========");
		for (int i = 0; i < visited.length; i++) {
			System.out.print(visited[i]+" " );
		}
		System.out.println();
		System.out.println("===========");
		for (int i = 0; i < parent.length; i++) {
			System.out.print(parent[i]+" " );
		}
		System.out.println();
		System.out.println("===========");
		for (int i = 0; i < distance.length; i++) {
			System.out.print(distance[i]+" " );
		}
		
	}
	
	
	
}
