package MST;

import java.util.Arrays;
import java.util.HashSet;

public class Kruskal {
	public int edge;
	private char[] vertex; //��������
	private int[][] matrix; //�ٽӾ���
	protected static final int INF = Integer.MAX_VALUE; //ʹ�����ֵ��ʾ�������㲻����ͨ
	public static HashSet<Character> added = new HashSet<Character>();
	
	public Kruskal(char[] vertex, int[][] weight) {
		int vlen = vertex.length;
		//��ʼ������
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
		//ͳ�Ʊ�
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < matrix[0].length; j++) {
				if (matrix[i][j] !=INF && matrix[i][j]!=0) {
					edge++;
				}
			}
		}	
	}
	
	public void show() {
		System.out.println("�ٽӾ���");
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

	/** ���ͼ�еıߣ�����������
	 * ͨ���ٽӾ����ȡ
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

	//�Ա߽�������
	public static void sort(EdgeData[] element, int left, int right) {
			int lo = left;
			int hi = right;
			EdgeData temp = null;
			int pivotIndex= left;
			int pivot = element[pivotIndex].distance;
			
			while (lo<hi) {
				//������ҵ�һ����=pivot��ֵ
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
		
	
	/** ��ȡ�±�Ϊi�Ķ�����յ�
	 *  Ϊ���ж���û�л�·
	 * @return
	 */
	private int getEnd(int[] ends, int i) {
		while(ends[i]!=0) {
			i = ends[i];
		}
		return i;
	}

	public void kruskal() {
		int index = 0; //��ʾ��������������
		int[] ends = new int[edge];//���ڱ�������·���Ķ���->�յ�
		//�����������
		EdgeData[] result = new EdgeData[edge];
		//��ȡͼ�����еıߵļ���
		EdgeData[] edges = getEdges();
		sort(edges, 0, edges.length-1);
		//����edges���飬������ӵ���С�������У��ж��Ƿ��γ��˻�·�����û�У��ͼ���
		for (int i = 0; i < edge; i++) {
			//��ȡ���� i ���ߵĵ�һ������
			int p1= getPosition(edges[i].start);
			//��ȡ���� i ���ߵĵڶ�������
			int p2= getPosition(edges[i].end);
			//��ȡP1 P2�Ƿ��Ѿ����յ�
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);
			//�Ƿ񹹳ɻ�·
			if(m!=n) {
				ends[m]=n;
				result[index++] = edges[i];
				System.out.println("��"+index+"���߼���" +edges[i]);
			}
		}
		
	}

	
}
