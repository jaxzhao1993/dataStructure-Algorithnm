package BinaryTree;

public class BinarySortTree {
	private Node rootNode;
	
	public void add(Node node) {
		if(rootNode ==null) {
			rootNode = node;
		}else {
			rootNode.add(node);
		}
	}
	
	public void infixOrder() {
		if (rootNode!=null) {
			rootNode.infixOrder();
		} else {
			System.out.println("¿ÕÊ÷");
		}
	}
}
