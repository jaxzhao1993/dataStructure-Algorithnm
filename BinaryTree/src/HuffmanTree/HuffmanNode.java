package HuffmanTree;


public class HuffmanNode implements Comparable<HuffmanNode>{
	
	private int value;//节点全职
	HuffmanNode leftNode;
	HuffmanNode rightNode;
	
	public HuffmanNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(HuffmanNode o) {
		return this.value-o.value; //从小到大排序
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public HuffmanNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(HuffmanNode leftNode) {
		this.leftNode = leftNode;
	}

	public HuffmanNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(HuffmanNode rightNode) {
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
