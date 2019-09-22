package MST;

import java.util.Arrays;
import java.util.Iterator;

public class Graph {
	int vertex; //ͼ�Ľڵ����
	char[] city; //�������
	int[][] weight;//��űߣ�Ҳ�����ٽӾ���
	
	public Graph(int vertex){
		this.vertex = vertex;
		city = new char[vertex];
		weight = new int[vertex][vertex];
	}

	public void createGraph(char[] data, int[][] weight) {
		for (int i = 0; i < this.weight.length; i++) {
			this.city[i] = data[i];
			for (int j = 0; j < this.weight.length; j++) {
				this.weight[i][j] = weight[i][j];
			}
		}
	}
	
	public void showGraph() {
		for (int[] link : weight) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	/**
	 * @param v��ͼ�ĵڼ�����������
	 */
	public void prim(int v) {
		//��Ƕ����Ƿ��Ѿ����Ե���
		int[] added = new int[vertex];
		added[v] = 1;
		//��¼����������±�
		int h1 = -1;
		int h2 = -1;
		int miniWeight = 10000; //��miniweight ��ʼ��һ������
		//����ʹ�����ȶ�������
		for (int k = 1; k < vertex; k++) { //��Ϊ����ô������㣬������n-1����
				
			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < vertex; j++) {
					if(added[i]==1 && added[j] ==0 &&
						weight[i][j] < miniWeight	) {
						miniWeight = weight[i][j];
						h1=i;
						h2=j;
					}
				}
			}
			System.out.println("��<"+ city[h1] + ","+ city[h2] + "> Ȩֵ��" + miniWeight);
			miniWeight = 10000;
			added[h2]=1;
		}
		
	}
}
