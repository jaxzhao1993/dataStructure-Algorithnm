package SparseArray;

public class SparseArray {
	public static void main(String[] args) {
		//创建原始数组 11*11
		// 0：没有棋子 1：黑子 2：白字
		int chessArray[][] = new int[6][7];
		chessArray[0][3] = 22;
		chessArray[0][6] = 15;
		chessArray[1][1] = 11;
		chessArray[1][5] = 17;
		chessArray[2][3] = -6;
		chessArray[3][5] = 39;
		chessArray[4][0] = 91;
		chessArray[5][2] = 28;

		for (int[] row : chessArray) {
			for (int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		int array[][] =toSparseArr(chessArray);
		for (int[] row : array) {
			for (int data : row) {
				System.out.printf("%d  ", data);
			}
			System.out.println();
		}
	}
	
	public static int[][] toSparseArr(int[][] original) {
		int sum = 0;
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[i].length; j++) {
				if (original[i][j] !=0) {
					sum++;
				}
			}
		}
		System.out.println("一共有："+sum+ "个元素");
		int sparseArr[][] = new int[sum+1][3];
		//给稀疏数组赋值
		sparseArr[0][0] = original.length;
		sparseArr[0][1] = original[0].length;
		sparseArr[0][2] = sum;
		//再次遍历二维数组，赋值
		
		int count = 0;
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[i].length; j++)
			{
				if (original[i][j] !=0) 
				{	
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = original[i][j];
				}
			}
		}
		
		return sparseArr;
	}
}
