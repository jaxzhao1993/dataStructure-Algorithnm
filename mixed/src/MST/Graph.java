package MST;

import java.util.Arrays;
import java.util.Iterator;

public class Graph {
	int vertex; //图的节点个数
	char[] city; //保存城市
	int[][] weight;//存放边，也就是临接矩阵
	
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
	 * @param v从图的第几个顶点生成
	 */
	public void prim(int v) {
		//标记顶点是否已经可以到达
		int[] added = new int[vertex];
		added[v] = 1;
		//记录两个顶点的下标
		int h1 = -1;
		int h2 = -1;
		int miniWeight = 10000; //将miniweight 初始成一个大数
		//可以使用优先队列来解
		for (int k = 1; k < vertex; k++) { //因为有这么多个顶点，所以是n-1条边
				
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
			System.out.println("边<"+ city[h1] + ","+ city[h2] + "> 权值：" + miniWeight);
			miniWeight = 10000;
			added[h2]=1;
		}
		
	}
}
