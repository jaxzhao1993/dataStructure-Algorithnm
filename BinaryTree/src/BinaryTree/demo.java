package BinaryTree;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7,3,10,12,5,1,9};
		BinarySortTree bTree = new BinarySortTree();
		for (int i = 0; i < array.length; i++) {
			Node node = new Node(array[i]);
			bTree.add(node);
		}
		bTree.infixOrder();
	}

}
