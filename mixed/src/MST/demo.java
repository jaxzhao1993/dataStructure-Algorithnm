package MST;

import java.util.Arrays;

public class demo {
	public static void main(String[] args) {
		int INF= Kruskal.INF;
		char[] city = {'A','B','C','D','E','F','G'};
		//0��ʾ�����Լ���INF��ʾ�޷���ͨ
		int[][] weight = {
				{0,12,INF,INF,INF,16,14},
				{12,0,10,INF, INF, 7, INF},
				{INF,10,0,3,5,6,INF},
				{INF,INF,3,0,4,INF,INF},
				{INF,INF,5,4,0,2,8},
				{16,7,6,INF,2,0,9},
				{14,INF,INF,INF,8,9,0}
		};
		
		Kruskal graph = new Kruskal(city, weight);
		//graph.show();
		EdgeData[] edge = graph.getEdges();
		Kruskal.sort(edge, 0, edge.length-1);
		//System.out.println(Arrays.toString(edge));
		graph.kruskal();
		
		
		
		
		
// ʹ��hashset ��bug�� DE�߾�û����ӽ�ȥ
//		for (int i = 0; i < edge.length; i++) {
//			if( Kruskal.added.contains(edge[i].start) &&
//				Kruskal.added.contains(edge[i].end)) {
//				//System.out.println(edge[i]+"���ʧ��");
//				continue;
//			}
//			System.out.println("��ӳɹ�" + edge[i]);
//			Kruskal.added.add(edge[i].start);
//			Kruskal.added.add(edge[i].end);
//		}
//		System.out.println(Kruskal.added);
	}
}
