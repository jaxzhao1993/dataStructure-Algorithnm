package cheese;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int	row =1;
		int column=1;

		//boolean[] visited = new boolean[X*Y];
		
		long start = System.currentTimeMillis();
		HorseCheese.traversalChess(row-1, column-1, 1);
		long end = System.currentTimeMillis();
		System.out.println(start-end);
		// ‰≥ˆ∆Â≈Ã
		for(int[] rows: HorseCheese.chessBoard) {
			for(int step: rows) {
				System.out.print(start + "\t");
			}
			System.out.println();
		}
		
	}

}
