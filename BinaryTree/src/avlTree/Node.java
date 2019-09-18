package avlTree;

public class Node {
	Node leftNode;
	Node rightNode;
	int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	//�����Ե�ǰ�ڵ�Ϊ���ڵ�����������������߶�
	public int leftHeight() {
		 if(leftNode==null){
			 return 0;
		 }else {
			return this.leftNode.height();
		}
	}
	
	public int rightHeight() {
		 if(rightNode==null){
			 return 0;
		 }else {
			return rightNode.height();
		}
	}
	
	public int height() {
		return Math.max(leftNode==null? 0:leftNode.height(), rightNode==null? 0:rightNode.height())+1;
	}
	//��ӽڵ�ķ�������Ҫ���������������Ҫ��
	//�ݹ����ʽ���
	public void add(Node node) {
		if (node == null) {
			return;
		}
		//�жϴ���Ľڵ��ֵ���͵�ǰ�������ڵ�Ĺ�ϵ
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
		//�������һ���ڵ�� ��rightHeight - leftHeight��>1 =>����ת
		if(rightHeight() - leftHeight() >1) {
			if (rightNode.leftHeight()> rightNode.rightHeight()) {
				rightNode.leftRotate();
			}
			leftRotate();
			return;
		}
		
		if (leftHeight() - rightHeight() >1) {
			//������������������� �������������ĸ߶ȣ�
			if (leftNode.rightHeight() > leftNode.leftHeight()) {
				//�ȶ���������������ת
				leftNode.leftRotate();
			}
			rightRotate();
			return;
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
	 * @return Ҫ�ҵĽڵ�ĸ��ڵ�
	 */
	public Node searchParent(int target) {
		if ((this.leftNode!=null && this.leftNode.value==target) ||
			(this.rightNode!=null && this.rightNode.value == target)){
			return this;
		}else {
			//������ҵ�ֵС�ڵ�ǰ�ڵ㣬���ҵ�ǰ�ڵ����ӽڵ㲻Ϊ��
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
		//�ҵ���ǰ��������Сֵ
		int temp = this.value;
		if (this.leftNode!=null) {
			return this.leftNode.searchMini();
		}else {
			return this.value;
		}
	}

	public void leftRotate() {
		//�����µĽڵ㣬ֵ=��ǰ�ڵ�
		Node newNode = new Node(this.value);
		//���½ڵ�������� = ��ǰ�ڵ��������
		newNode.leftNode = this.leftNode;
		//�½ڵ�������� = ��ǰ�ڵ�������.������
//		if (this.rightNode.leftNode!=null) {
//			newNode.rightNode = this.rightNode.leftNode;
//		}else {
//			newNode.rightNode = this.rightNode;
//		}
		newNode.rightNode = this.rightNode.leftNode;
		//�ѵ�ǰ�ڵ��ֵ�滻Ϊ���ӽڵ��ֵ
		this.value = this.rightNode.value;
		//��ǰ�ڵ�������� = ԭ��������������
		this.rightNode = this.rightNode.rightNode;
		//�ѵ�ǰ�ڵ��������,���ó��µĽڵ�
		this.leftNode = newNode;
	
	}

	public void rightRotate() {
		Node newNode = new Node(value);
		//�½ڵ������� = ��ǰ�ڵ��������
		newNode.rightNode = rightNode;
		//�½ڵ�������� = ��ǰ�ڵ���������������
		newNode.leftNode = leftNode.rightNode;
		//��ǰ�ڵ��ֵ�滻Ϊԭ���ӽڵ��ֵ
		value = leftNode.value;
		//��ǰ�ڵ�������� =ԭ��������������
		leftNode = leftNode.leftNode;
		//�ѵ�ǰ�ڵ��������,���ó��µĽڵ�
		rightNode = newNode;
	}
}
