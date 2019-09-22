package Dijkstra;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		char[] city = {'A','B','C','D','E','F','G'};
		int[][] distance = new int[city.length][city.length];
		final int N = 65535;
		distance[0] = new int[] {N,5,7,N,N,N,2};
		distance[1] = new int[] {5,N,N,9,N,N,3};
		distance[2] = new int[] {7,N,N,N,8,N,N};
		distance[3] = new int[] {N,9,N,N,N,4,N};
		distance[4] = new int[] {N,N,8,N,N,5,4};
		distance[5] = new int[] {N,N,N,4,5,N,6};
		distance[6] = new int[] {2,3,N,N,4,6,N};
		
		Dijkstra graph = new Dijkstra(city, distance);
		
		graph.dsj(6);
		graph.show();
	}
	}
	
		
