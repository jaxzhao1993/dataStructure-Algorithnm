package MST;

import java.util.Arrays;
import java.util.HashSet;

public class Kruskal {
	public int edge;
	private char[] vertex; //顶点数组
	private int[][] matrix; //临接矩阵
	protected static final int INF = Integer.MAX_VALUE; //使用最大值表示两个顶点不能连通
	public static HashSet<Character> added = new HashSet<Character>();
	
	public Kruskal(char[] vertex, int[][] weight) {
		int vlen = vertex.length;
		//初始化顶点
		this.vertex = new char[vlen];
		for(int i = 0;i< vertex.length; i++)
		{
			this.vertex[i] = vertex[i];
		}
		//this.vertex = vertex;
		this.matrix = new int[vlen][vlen];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = weight[i][j];
			}
		}
		//统计边
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < matrix[0].length; j++) {
				if (matrix[i][j] !=INF && matrix[i][j]!=0) {
					edge++;
				}
			}
		}	
	}
	
	public void show() {
		System.out.println("临接矩阵");
		for (int[] link : matrix) {
			for (int i : link) {
				System.out.printf("%12d",i);
			}
			System.out.println();
		}
		
	}

	private int getPosition(char ch) {
		for (int i = 0; i <vertex.length ; i++) {
			if(vertex[i]==ch){
				return i;
			}
		}
		return -1;
	}

	/** 获得图中的边，放入数组中
	 * 通过临接矩阵获取
	 * @return
	 */
	public EdgeData[] getEdges() {
		int index = 0;
		EdgeData[] edges= new EdgeData[edge];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < matrix[0].length; j++) {
				if(matrix[i][j]!=INF && matrix[i][j]!=0) {
					edges[index++] = new EdgeData(vertex[i], vertex[j], matrix[i][j]);
				}
			}
		}
		return edges;
	}

	//对边进行排序
	public static void sort(EdgeData[] element, int left, int right) {
			int lo = left;
			int hi = right;
			EdgeData temp = null;
			int pivotIndex= left;
			int pivot = element[pivotIndex].distance;
			
			while (lo<hi) {
				//在左边找到一个》=pivot的值
				while (element[lo].distance <pivot) {
					lo=lo+1;
				}
				while (element[hi].distance > pivot) {
					hi=hi-1;
				}
				if (lo>=hi) {
					break;
				}
				temp = element[lo];
				element[lo] = element[hi];
				element[hi] = temp;
				if(element[lo].distance ==pivot) {
					hi=hi-1;
				}
				if(element[hi].distance == pivot) {
					lo= lo+1;
				}
			}
			
			if(hi==lo) {
				lo++;
				hi--;
			}
			if (left<hi) {
				sort(element, left, hi);
			}
			if(lo<right) {
				sort(element, lo, right );
			}
		}
		
	
	/** 获取下标为i的顶点的终点
	 *  为了判断有没有回路
	 * @return
	 */
	private int getEnd(int[] ends, int i) {
		while(ends[i]!=0) {
			i = ends[i];
		}
		return i;
	}

	public void kruskal() {
		int index = 0; //表示最后结果数组的索引
		int[] ends = new int[edge];//用于保存已有路径的顶点->终点
		//创建结果数组
		EdgeData[] result = new EdgeData[edge];
		//获取图中所有的边的集合
		EdgeData[] edges = getEdges();
		sort(edges, 0, edges.length-1);
		//遍历edges数组，将边添加到最小生成树中，判断是否形成了回路，如果没有，就加入
		for (int i = 0; i < edge; i++) {
			//获取到第 i 条边的第一个顶点
			int p1= getPosition(edges[i].start);
			//获取到第 i 条边的第二个顶点
			int p2= getPosition(edges[i].end);
			//获取P1 P2是否已经是终点
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);
			//是否构成回路
			if(m!=n) {
				ends[m]=n;
				result[index++] = edges[i];
				System.out.println("第"+index+"条边加入" +edges[i]);
			}
		}
		
	}

	
}
