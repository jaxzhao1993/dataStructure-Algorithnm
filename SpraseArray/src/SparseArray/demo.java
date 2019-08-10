package SparseArray;

public class demo {
public static void main(String[] args) {
	int b[][]={{1,5,2,8},{5,9,10,-3},{2,7,-5}};
	for (int[] is : b) {
		for (int is2 : is) {
			System.out.printf("%d\t",is2);
		}
		System.out.println();
	}
}
}
