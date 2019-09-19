package graph;

public class demo {
	public static void main(String[] args) {
		//String[] vertex= {"A","B","C","D","E"};
		String[] vertex= {"1","2","3","4","5","6","7","8"};
		Graph graph= new Graph(vertex.length);
		for(String value: vertex){
			graph.insertVertex(value);
		}
		//Ìí¼Ó±ß A-B A-C B-C B-D B-E
//		graph.insertEdges(0, 1, 1);
//		graph.insertEdges(0, 2, 1);
//		graph.insertEdges(1, 2, 1);
//		graph.insertEdges(1, 3, 1);
//		graph.insertEdges(1, 4, 1);
		
		graph.insertEdges(0, 1, 1);
		graph.insertEdges(0, 2, 1);
		graph.insertEdges(1, 3, 1);
		graph.insertEdges(1, 4, 1);
		graph.insertEdges(3, 7, 1);
		graph.insertEdges(4, 7, 1);
		graph.insertEdges(2, 5, 1);
		graph.insertEdges(2, 6, 1);
		graph.insertEdges(5, 6, 1);
		
		
		
		System.out.print("dfs: ");
		graph.dfs(0);
		System.out.println();
		System.out.print("bfs: ");
		graph.bfs(0);
	}
}
