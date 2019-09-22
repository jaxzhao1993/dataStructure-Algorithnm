package floyd;

import java.util.Arrays;

public class Graph {
	private char[] city;
	private int[][] distance;// ����Ӹ��������������������ľ���
	private int[][] through; //���浽��Ŀ�궥���ǰ��
	
	public Graph(char[] city, int[][] matrix) {
		this.city = city;
		distance = matrix;
		through = new int[city.length][city.length];
		for (int i = 0; i < through.length; i++) {
			Arrays.fill(through[i], i);
		}
		
	}
	
	public void show() {
		System.out.println("distance����");
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[i].length; j++) {
				System.out.printf("%10d", distance[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Through���飺");
		for (int i = 0; i < through.length; i++) {
			for (int j = 0; j < through[i].length; j++) {
				System.out.printf(city[through[i][j]] +" ");
			}
			System.out.println();
		}
	}

	public void floyd() {
		//�������
		int len = 0;
		
		// k�м䶥����±�
		for (int k = 0; k < distance.length; k++) {
			//i ��������
			for (int i = 0; i < city.length; i++) {
				//J�����
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
