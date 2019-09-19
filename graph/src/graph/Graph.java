package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Graph {
	private ArrayList<String> verteList; //�洢���㼯��
	private int[][] edges;//�洢ͼ��Ӧ���ٽӾ���
	private int numberOfEdges; // ��ʾ�ߵ���Ŀ
	
	
	//��ʼ������
	public Graph(int n) {
		edges = new int[n][n];
		verteList = new ArrayList<String>(n);
		numberOfEdges = 0;
	}
	
	// �õ��ٽӽڵ���±�
	public List<Integer> getSuccessor(int v1) {
		boolean[] isAdded = new boolean[verteList.size()];
		List<Integer> successors = new ArrayList<Integer>();
		isAdded[v1]=true;
		for(int j = 0; j< edges[0].length; j++) {
			if (edges[v1][j] >0 && isAdded[j] ==false) {
				successors.add(j);
				isAdded[j]=true;
			}
		}
		return successors;
	}
	
	public void bfs(int i) {
		boolean[] isVisited = new boolean[verteList.size()];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		int current;
		while (!q.isEmpty()) {
			current = q.poll();
			isVisited[current]=true;
			System.out.print(getValueByIndex(current) + "-> " );
			List<Integer> successors = new ArrayList<Integer>();
			successors = getSuccessor(current);
			//System.out.println("sc"+successors);
			if (successors.size()!=0) {
				for(int j = 0; j<successors.size();j++) {		
					int temp = successors.get(j);
					if (isVisited[temp]==false) {
						q.offer(successors.get(j));
						isVisited[temp]=true;
					}
				}
			}			
		}
	}
	
	public void dfs(int i) {
		boolean[] isVisited = new boolean[verteList.size()];
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(i);
		int current;
		while(!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(getValueByIndex(current) + "-> " );
			isVisited[current] = true;
			List<Integer> successors = new ArrayList<Integer>();
			successors =getSuccessor(current);
		//	System.out.println("succ" + successors);
			if(successors.size()!=0) {
				for(int j = 0; j<successors.size();j++) {			
					int temp = successors.get(j);
					if(isVisited[temp]==false) {
						stack.push(temp);
						isVisited[temp]=true;
					}
				}
			}	
		}
		
	}
	
 	public void insertVertex(String vertex) {
		verteList.add(vertex);
	}
	
	public void insertEdges(int v1, int v2, int distance) {
		edges[v1][v2] = distance;
		edges[v2][v1] = distance;
		numberOfEdges ++ ;
	}
	
	//ͼ�г��õķ�����
	public int getNumOfVertex() {
		return verteList.size();
	}
	
	public int getNumOfEdge() {
		return numberOfEdges;
	}
	
	//���ؽڵ��±��Ӧ������
	public String getValueByIndex(int i) {
		return verteList.get(i);
	}
	//����V1,V2Ȩֵ
	public int getDistance(int v1, int v2) {
		return edges[v1][v2];
	}
	
	public void show() {
		for(int[] link:edges) {
			System.err.println(Arrays.toString(link));
		}
	}
	
}
