package HuffmanTree;


public class Node implements Comparable<Node>{
	
	private int value;//�ڵ�ȫְ
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
		return this.value-o.value; //��С��������
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
	//ǰ�������
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
