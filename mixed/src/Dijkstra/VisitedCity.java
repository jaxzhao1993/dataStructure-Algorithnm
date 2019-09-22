package Dijkstra;

import java.util.Arrays;
import java.util.List;

public class VisitedCity {
	public boolean[] visited;
	public int[] parent;
	public int[] distance;
	
	/**
	 * @param city
	 * @param index 表示出发顶点
	 */
	public VisitedCity(char[] city, int index) {
		this.visited = new boolean[city.length];
		this.parent = new int[city.length];
		this.distance = new int[city.length];
		//初始化dis数组
		Arrays.fill(distance, 65535);
		distance[index] = 0;
		visited[index] =true;
	}
	

	//判断index 顶点是否被访问过
	public boolean in(int index) {
		return visited[index];
	}
	
	/** 更新出发顶点到index的距离
	 * @param index
	 * @param minDis
	 */
	public void updateDistance(int index, int minDis) {
		distance[index] = minDis;
	}
	
	public void updateParent(int index, int pre) {
		parent[index] = pre;
	}
	
	//返回出发点到index的距离
	public int getDis(int index) {
		return distance[index];
	}
	
	//从还没访问过的节点中，选出离当前节点距离最近的那个节点
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
