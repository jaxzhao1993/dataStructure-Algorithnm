package avlTree;

public class Node {
	Node leftNode;
	Node rightNode;
	int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	//返回以当前节点为根节点的左子树，右子树高度
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
		//当添加完一个节点后： （rightHeight - leftHeight）>1 =>左旋转
		if(rightHeight() - leftHeight() >1) {
			if (rightNode.leftHeight()> rightNode.rightHeight()) {
				rightNode.leftRotate();
			}
			leftRotate();
			return;
		}
		
		if (leftHeight() - rightHeight() >1) {
			//如果左子树的右子树》 左子树左子树的高度，
			if (leftNode.rightHeight() > leftNode.leftHeight()) {
				//先对左子树进行左旋转
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

	public void leftRotate() {
		//创建新的节点，值=当前节点
		Node newNode = new Node(this.value);
		//把新节点的左子树 = 当前节点的左子树
		newNode.leftNode = this.leftNode;
		//新节点的右子树 = 当前节点右子树.左子树
//		if (this.rightNode.leftNode!=null) {
//			newNode.rightNode = this.rightNode.leftNode;
//		}else {
//			newNode.rightNode = this.rightNode;
//		}
		newNode.rightNode = this.rightNode.leftNode;
		//把当前节点的值替换为右子节点的值
		this.value = this.rightNode.value;
		//当前节点的右子树 = 原右子树的右子树
		this.rightNode = this.rightNode.rightNode;
		//把当前节点的左子树,设置成新的节点
		this.leftNode = newNode;
	
	}

	public void rightRotate() {
		Node newNode = new Node(value);
		//新节点右子树 = 当前节点的右子树
		newNode.rightNode = rightNode;
		//新节点的左子树 = 当前节点左子树的右子树
		newNode.leftNode = leftNode.rightNode;
		//当前节点的值替换为原左子节点的值
		value = leftNode.value;
		//当前节点的左子树 =原左子树的左子树
		leftNode = leftNode.leftNode;
		//把当前节点的右子树,设置成新的节点
		rightNode = newNode;
	}
}
