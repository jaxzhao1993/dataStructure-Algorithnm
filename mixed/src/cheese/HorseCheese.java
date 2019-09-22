package cheese;

import java.awt.Point;
import java.util.ArrayList;

public class HorseCheese {
	private static int x=8; //棋盘列数
	private static int y=8; //棋盘行数
	//创建一个数组，标记棋盘各个位置是否被访问过
	private static boolean[] visited = new boolean[x*y];
	private static boolean finished;
	public static int[][] chessBoard = new int[x][y];
	
	public static ArrayList<Point> getSuccessors( Point current) {
		ArrayList<Point> successors =  new ArrayList<Point>();
		Point p = new Point();
		if ((p.x = current.x-2)>=0 && (p.y =current.y-1)>=0) {
			successors.add(new Point(p));
		}
		if ((p.x = current.x-1)>=0 && (p.y =current.y-2)>=0) {
			successors.add(new Point(p));
		}
		if ((p.x = current.x-2)>=0 && (p.y =current.y+1)<y) {
			successors.add(new Point(p));
		}
		if ((p.x = current.x-1)>=0 && (p.y =current.y+2)<y) {
			successors.add(new Point(p));
		}
		if ((p.x = current.x+2)<x && (p.y =current.y+1)<y) {
			successors.add(new Point(p));
		}
		if ((p.x = current.x+1)<x && (p.y =current.y+2)<y) {
			successors.add(new Point(p));
		}
		if ((p.x = current.x+1)<x && (p.y =current.y-2)>=0) {
			successors.add(new Point(p));
		}
		if ((p.x = current.x+2)<x && (p.y =current.y-1)>=0) {
			successors.add(new Point(p));
		}
		
		return successors;
	}

	/** 完成骑士周游问题的算法
	 * @param chessBoard  棋盘
	 * @param row	从0行开始
	 * @param column
	 * @param step 这是第几步,初始位置为1
	 */
	public static void traversalChess( int row, int column, int step) {
		chessBoard[row][column] = step;
		//row表示第几行 
		visited[x*row + column] = true;
		//获取当前位置可以走的集合
		ArrayList<Point> successors = getSuccessors(new Point(column,row));
		//遍历successors
		while(!successors.isEmpty()) {
			System.out.println("1");
			Point p = successors.remove(0); //取出下一个可以走的位置
			//改点是否已经访问过了
			if(visited[p.y * x +p.x] !=true) {
				System.out.println("进入下一步");
				traversalChess( p.y, p.x, step+1);
			}
		}
		if (step< x*y && !finished) {
			chessBoard[row][column]=0;
			visited[row*x + column] =false;
		}else {
			finished = true;
		}
		
	}
	
}
