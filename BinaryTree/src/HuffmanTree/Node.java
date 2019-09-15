package HuffmanTree;


public class Node implements Comparable<Node>{
	
	private int value;//节点全职
	Node leftNode;
	Node rightNode;
	
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		return this.value-o.value; //从小到大排序
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	//前序遍历：
	public void preOrder() {
		System.out.println(this);
		if (this.leftNode!=null) {
			this.leftNode.preOrder();
		}
		if (this.rightNode!=null) {
			this.rightNode.preOrder();
		}
	}
	
}
