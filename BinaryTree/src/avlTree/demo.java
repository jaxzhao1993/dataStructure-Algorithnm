package avlTree;

public class demo {
	public static void main(String[] args) {
		int[] arr = {4,3,6,5,7,8};
		AvlTree avlTree = new AvlTree();
		for (int i = 0; i < arr.length; i++) {
			avlTree.add(new Node(arr[i]));
		}
		
		System.out.println("根节点:  "+avlTree.getRootNode());
		avlTree.infixOrder();
		
		System.out.println("平衡前");
		System.out.println("树的高度:  " + avlTree.getRootNode().height());
		System.out.println("树的左子树高度:  " + avlTree.getRootNode().leftHeight());
		System.out.println("树的右子树高度:  " + avlTree.getRootNode().rightHeight());
		
	}
}
