package floyd;

public class Floyd {
	public static void main(String[] args) {
		char[] city = {'A','B','C','D','E','F','G'};
		int[][] distance = new int[city.length][city.length];
		final int N = 65535;
		distance[0] = new int[] {0,5,7,N,N,N,2};
		distance[1] = new int[] {5,0,N,9,N,N,3};
		distance[2] = new int[] {7,N,0,N,8,N,N};
		distance[3] = new int[] {N,9,N,0,N,4,N};
		distance[4] = new int[] {N,N,8,N,0,5,4};
		distance[5] = new int[] {N,N,N,4,5,0,6};
		distance[6] = new int[] {2,3,N,N,4,6,0};
		
		Graph graph = new Graph(city, distance);
		graph.floyd();
		graph.show();
	}
}

