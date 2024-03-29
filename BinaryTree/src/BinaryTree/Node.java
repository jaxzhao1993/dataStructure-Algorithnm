package BinaryTree;

public class Node {
	Node leftNode;
	Node rightNode;
	int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	//添加节点的方法，需要满足二叉排序树的要求
	//递归的形式添加
	public void add(Node node) {
		if (node == null) {
			return;
		}
		//判断传入的节点的值，和当前子树根节点的关系
		if (node.value < this.value) {
			if (this.leftNode == null) {
				this.leftNode = node;
			}else {
				this.leftNode.add(node);
			}	
		}else {
			if (this.rightNode ==null) {
				this.rightNode = node;
			}else {
				this.rightNode.add(node);
			}
		}
	}
	
	public void infixOrder() {
		if(this.leftNode!=null) {
			this.leftNode.infixOrder();
		}
		System.out.println(this);
		if (this.rightNode!= null) {
			this.rightNode.infixOrder();
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public Node search(int target) {
		if(this.value == target){
			return this;
		}else if(target< this.value){
			if (this.leftNode ==null) {
				return null;
			}
			return this.leftNode.search(target);
		}else {
			if(this.rightNode==null) {
				return null;
			}
			return this.rightNode.search(target);
		}
	}

	/**
	 * @param target
	 * @return 要找的节点的父节点
	 */
	public Node searchParent(int target) {
		if ((this.leftNode!=null && this.leftNode.value==target) ||
			(this.rightNode!=null && this.rightNode.value == target)){
			return this;
		}else {
			//如果查找的值小于当前节点，并且当前节点左子节点不为空
			if (this.leftNode!=null && this.value> target) {
				return this.leftNode.searchParent(target);
			}else if (this.rightNode!=null && this.value <= target) {
				return this.rightNode.searchParent(target);
			}else {
				return null;
			}
		}
		
	}

	public int searchMini() {
		//找到当前子树的最小值
		int temp = this.value;
		if (this.leftNode!=null) {
			return this.leftNode.searchMini();
		}else {
			return this.value;
		}
	}
}
