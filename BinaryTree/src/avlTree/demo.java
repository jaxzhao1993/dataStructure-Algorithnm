package avlTree;

public class demo {
	public static void main(String[] args) {
		int[] arr = {4,3,6,5,7,8};
		AvlTree avlTree = new AvlTree();
		for (int i = 0; i < arr.length; i++) {
			avlTree.add(new Node(arr[i]));
		}
		
		System.out.println("���ڵ�:  "+avlTree.getRootNode());
		avlTree.infixOrder();
		
		System.out.println("ƽ��ǰ");
		System.out.println("���ĸ߶�:  " + avlTree.getRootNode().height());
		System.out.println("�����������߶�:  " + avlTree.getRootNode().leftHeight());
		System.out.println("�����������߶�:  " + avlTree.getRootNode().rightHeight());
		
	}
}
