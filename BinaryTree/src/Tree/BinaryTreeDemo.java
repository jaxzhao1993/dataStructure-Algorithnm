package Tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node node1 = new Node(1, "�ν�");
		Node node2 = new Node(2, "¬����");
		Node node3 = new Node(3, "����");
		Node node4 = new Node(4, "����ʤ");
		Node node5 = new Node(5, "��ʤ");

		//�ֶ�����������
		tree.setRoot(node1);
		node1.setLeftnodNode(node3);
		node1.setRightNode(node2);
		node2.setRightNode(node4);
		node2.setLeftnodNode(node5);
		
		System.out.println("ɾ��ǰ");
		tree.preOrder();
		System.out.println("ɾ����");
		tree.deleteNode2(2);
		tree.preOrder();
//		
//		System.out.println();
//		tree.infixOrder();
//		
//		System.out.println();
//		tree.postOrder();
		
		//Node resultNode = tree.preOrderSearch(5);
		//Node resultNode = tree.infixOrderSearch(5);
//		Node resultNode = tree.postOrderSearch(5);
//		if (resultNode!=null) {
//			System.out.println(resultNode);
//		}else {
//			System.out.println("not found");
//		}
	}
}
