package HuffmanTree;


public class HuffmanNode implements Comparable<HuffmanNode>{
	
	private int value;//�ڵ�ȫְ
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
		return this.value-o.value; //��С��������
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
