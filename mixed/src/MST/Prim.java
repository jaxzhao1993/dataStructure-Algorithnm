package MST;

public class Prim {
	public static void main(String[] args) {
		char[] city = {'A','B','C','D','E','F','G'};
		int[] cityNo = {1,2,3,4,5,6,7};
		int vertex = city.length;
		int[][] weight = new int[][] {
			{10000,5,7,10000,10000,10000,2},
			{5,10000,10000,9,10000,10000,3},
			{7,10000,10000,10000,8,10000,10000},
			{10000,9,10000,10000,10000,4,10000},
			{10000,10000,8,10000,10000,5,4},
			{10000,10000,10000,4,5,10000,6},
			{2,3,10000,10000,4,6,10000}
		}; 

		Graph graph = new Graph(city.length);
		graph.createGraph( city, weight);
		graph.showGraph();
		
		graph.prim(0);
	}
}
