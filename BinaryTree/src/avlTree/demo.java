package avlTree;

public class demo {
	public static void main(String[] args) {
//		int[] arr = {4,3,6,5,7,8};
		int[] arr2 = {10,12,8,9,7,6,5,4,3};
		AvlTree avlTree = new AvlTree();
		for (int i = 0; i < arr2.length; i++) {
			avlTree.add(new Node(arr2[i]));
		}
		
		System.out.println("���ڵ�:  "+avlTree.getRootNode());
		avlTree.infixOrder();
		
		System.out.println("ƽ��ǰ");
		System.out.println("���ĸ߶�:  " + avlTree.getRootNode().height());
		System.out.println("�����������߶�:  " + avlTree.getRootNode().leftHeight());
		System.out.println("�����������߶�:  " + avlTree.getRootNode().rightHeight());
		
	}
}
