package cheese;

import java.awt.Point;
import java.util.ArrayList;

public class HorseCheese {
	private static int x=8; //��������
	private static int y=8; //��������
	//����һ�����飬������̸���λ���Ƿ񱻷��ʹ�
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

	/** �����ʿ����������㷨
	 * @param chessBoard  ����
	 * @param row	��0�п�ʼ
	 * @param column
	 * @param step ���ǵڼ���,��ʼλ��Ϊ1
	 */
	public static void traversalChess( int row, int column, int step) {
		chessBoard[row][column] = step;
		//row��ʾ�ڼ��� 
		visited[x*row + column] = true;
		//��ȡ��ǰλ�ÿ����ߵļ���
		ArrayList<Point> successors = getSuccessors(new Point(column,row));
		//����successors
		while(!successors.isEmpty()) {
			System.out.println("1");
			Point p = successors.remove(0); //ȡ����һ�������ߵ�λ��
			//�ĵ��Ƿ��Ѿ����ʹ���
			if(visited[p.y * x +p.x] !=true) {
				System.out.println("������һ��");
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
