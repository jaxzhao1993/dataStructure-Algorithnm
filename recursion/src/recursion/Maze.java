package recursion;

public class Maze {
	private int[][] maze;
	
	public Maze( int deepth, int width) {

		 maze = new int[deepth][width];
	}
		
	public void initialize() {
		for (int i = 0; i < maze.length; i++) {
			maze[i][0] = 1;
			maze[i][maze[0].length-1]=1;
		}
		for (int i = 0; i < maze[0].length; i++) {
			maze[0][i]=1;
			maze[maze.length-1][i]= 1;
		}
	}
	
	public void show() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.printf("%d  ", maze[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void obstacle(int depIndex, int widIndex) {
		maze[depIndex-1][widIndex-1]=1;
	}
	
	//maze[][]=0��ʾ��û�߹�
	// =1��ʾ������ 2��ʾ������ 3��ʾ������
	// ���߲��ԣ����������߲�ͨ������
	
	public boolean findWay(int firstX, int firstY, int endX, int endY) {
		if(maze[endY][endX]==2)
		{
			return true;
		}else {
			if (maze[firstY][firstX] ==0) {
				maze[firstY][firstX]=2;//��ǵ�ǰλ��
				if (findWay(firstX, firstY+1, endX, endY)) {
					return true;
				}else if (findWay(firstX+1, firstY, endX, endY)) {
					return true;
				}else if (findWay(firstX, firstY-1, endX, endY)) {
					return true;
				}else if (findWay(firstX-1, firstY, endX, endY)) {
					return true;
				}else {
					maze[firstY][firstX]=3;
					return false;
				}	
			}else 
			{
				return false;
			}
		}
		
}

	
	
	
	
	
	
	
	
	
}
