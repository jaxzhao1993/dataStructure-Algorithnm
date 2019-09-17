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

}
