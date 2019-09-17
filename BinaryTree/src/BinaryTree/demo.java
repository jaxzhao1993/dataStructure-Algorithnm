package BinaryTree;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7,3,10,12,5,1,9,2};
		BinarySortTree bTree = new BinarySortTree();
		for (int i = 0; i < array.length; i++) {
			Node node = new Node(array[i]);
			bTree.add(node);
		}
		bTree.infixOrder();
		bTree.deleteNode(2);
		bTree.deleteNode(5);
		bTree.deleteNode(9);
		bTree.deleteNode(12);
		bTree.deleteNode(7);
		bTree.deleteNode(3);
		bTree.deleteNode(1);
		bTree.deleteNode(10);

		System.out.println("===========");
		System.out.println(bTree.getRootNode());
		bTree.infixOrder();
	}

	
	
}
