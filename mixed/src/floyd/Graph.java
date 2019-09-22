package floyd;

import java.util.Arrays;

public class Graph {
	private char[] city;
	private int[][] distance;// 保存从各个顶点出发到其他顶点的距离
	private int[][] through; //保存到达目标顶点的前驱
	
	public Graph(char[] city, int[][] matrix) {
		this.city = city;
		distance = matrix;
		through = new int[city.length][city.length];
		for (int i = 0; i < through.length; i++) {
			Arrays.fill(through[i], i);
		}
		
	}
	
	public void show() {
		System.out.println("distance数组");
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[i].length; j++) {
				System.out.printf("%10d", distance[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Through数组：");
		for (int i = 0; i < through.length; i++) {
			for (int j = 0; j < through[i].length; j++) {
				System.out.printf(city[through[i][j]] +" ");
			}
			System.out.println();
		}
	}

	public void floyd() {
		//保存距离
		int len = 0;
		
		// k中间顶点的下标
		for (int k = 0; k < distance.length; k++) {
			//i 出发顶点
			for (int i = 0; i < city.length; i++) {
				//J到达点
				for (int j = 0; j < city.length; j++) {
					//len= Math.min(distance[i][k]+distance[j][j], distance[i][j]);
					len = distance[i][k]+distance[k][j];
					if(len<distance[i][j])
					{
						distance[i][j] = len;
						through[i][j] = through[k][j];
					}
				}
			}
		}
	}

}
