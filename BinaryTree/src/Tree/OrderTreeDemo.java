package Tree;

public class OrderTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7};
		OrderTree tree = new OrderTree(arr);
		tree.preOrder(0);
	}

}
