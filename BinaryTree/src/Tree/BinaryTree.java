package Tree;

public class BinaryTree {
	private Node root;
	
	public void setRoot(Node node) {
		root = node;
	}

	public void preOrder() {
		if (this.root !=null) {
			this.root.preOrder();
		}else {
			System.out.println("当前二叉树为空");
		}
	}
	
	
	public void infixOrder() {
		if (this.root !=null) {
			this.root.infixOrder();
		}else {
			System.out.println("当前二叉树为空");
		}
	}
	
	public void postOrder() {
		if (this.root !=null) {
			this.root.postOrder();
		}else {
			System.out.println("当前二叉树为空");
		}
	}

	public Node preOrderSearch(int no) {
		if(root==null)
		{
			return null;
		}else {
			return root.preOrderSearch(no);
		}
	}


	public Node infixOrderSearch(int no) {
		if(root==null)
		{
			return null;
		}else {
			return root.infixOrderSearch(no);
		}
	}


	public Node postOrderSearch(int no) {
		if(root==null)
		{
			return null;
		}else {
			return root.postOrderSearch(no);
		}
	}

	public void deleteNode(int no) {
		if (root==null) {
			System.out.println("空树");
			return;
		}
		if (root.getNumber() == no) {
			root=null;
			return;
		}else {
			root.deleteNode(no);
		}
	}
	
	public void deleteNode2(int no) {
		if (root==null) {
			System.out.println("空树");
			return;
		}
		if (root.getNumber() == no) {
			root=null;
			return;
		}else {
			root.deleteNode2(no);
		}
	}
}
