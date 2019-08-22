package recursion;


public class demo {
	public static void main(String[] args) {
		//先创建一个一个二维数组，模拟
	    Maze m1 = new Maze(8,7);
	    m1.initialize();
	    m1.obstacle(4, 3);
	    m1.obstacle(4, 2);
		m1.show();
		System.out.println("=================================");
		System.out.println();
		m1.findWay(1, 1, 1, 4);
		m1.show();
	}
}
