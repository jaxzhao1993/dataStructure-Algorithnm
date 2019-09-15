package Tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node node1 = new Node(1, "宋江");
		Node node2 = new Node(2, "卢俊义");
		Node node3 = new Node(3, "吴用");
		Node node4 = new Node(4, "公孙胜");
		Node node5 = new Node(5, "关胜");

		//手动创建二叉树
		tree.setRoot(node1);
		node1.setLeftnodNode(node3);
		node1.setRightNode(node2);
		node2.setRightNode(node4);
		node2.setLeftnodNode(node5);
		
		System.out.println("删除前");
		tree.preOrder();
		System.out.println("删除后");
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
