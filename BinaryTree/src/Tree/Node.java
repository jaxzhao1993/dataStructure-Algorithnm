package Tree;

public class Node {
	private int number;
	private String name;
	private Node leftnodNode;
	private Node rightNode;//默认为Null
	
	public Node(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getLeftnodNode() {
		return leftnodNode;
	}

	public void setLeftnodNode(Node leftnodNode) {
		this.leftnodNode = leftnodNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return "Node [number=" + number + ", name=" + name + "]";
	}
	
	//前序遍历
	public void preOrder() {
		//先输出当前节点(父节点)
		System.out.println(this);
		//递归向左字数前序变量
		if (this.leftnodNode!= null) {
			this.leftnodNode.preOrder();
		}
		//递归向右字数前序遍历
		if (this.rightNode!=null) {
			this.rightNode.preOrder();
		}
	}
	
	//中序遍历 
	public void infixOrder() {
		//递归向左子树中序遍历
		if (this.leftnodNode!= null) {
			this.leftnodNode.infixOrder();
		}
		//输出当前节点(父节点)
		System.out.println(this);
		//递归向右字数中序遍历
		if (this.rightNode!=null) {
			this.rightNode.infixOrder();
		}
	}
	//后续遍历
	public void postOrder() {
		//递归向左子树后序遍历
		if (this.leftnodNode!= null) {
			this.leftnodNode.postOrder();
		}
		//递归向右字数后序遍历
		if (this.rightNode!=null) {
			this.rightNode.postOrder();
		}
		//输出当前节点(父节点)
		System.out.println(this);
	}
	
	public Node preOrderSearch(int no) {
		if(this.number == no)
		{
			return this;
		}
		//判断当前节点的左子节点是否为空，如果不为空，则继续递归前序查找
		//如果左递归前序查找，找到节点，则返回
		Node resNode = null;//用来标记是否找到了节点
		if(this.leftnodNode!=null)
		{
			resNode = this.leftnodNode.preOrderSearch(no);
		}
		if(resNode!=null)
		{
			//说明左子树上找到了
			return resNode;
		}
		if(this.rightNode !=null)
		{
			resNode = this.rightNode.preOrderSearch(no);
		}
		
		return resNode;
	}

	public Node infixOrderSearch(int no)
	{	Node resNode = null;
		if(this.leftnodNode!=null)
		{
			resNode=this.leftnodNode.infixOrderSearch(no);
		}
		if (resNode!=null) {
			return resNode;
		}
		if (this.number==no) {
			return this;
		}
		if (this.rightNode!=null) {
			resNode = this.rightNode.infixOrderSearch(no);
		}
		return resNode;
	}

	public Node postOrderSearch(int no) {
		Node resNode = null;
		if(this.leftnodNode!=null)
		{
			resNode = this.leftnodNode.postOrderSearch(no);
		}
		if (resNode!=null) {
			return resNode;
		}
		if(this.rightNode!=null)
		{
			resNode = this.rightNode.postOrderSearch(no);
		}
		if(this.number==no)
		{
			return this;
		}
		return resNode;
	}

	//删除的基本规定：
//	1.如果删除的节点是叶子节点，则删除该节点
//	2如果删除的节点是非叶子节点，则删除该子树
//	
//	思路：
//	1.因为我们的二叉树是单向的，所以我们需要另外一个指针来指向父节点
//	2 如果当前节点的左子节点不为空，并且左子节点就是要删除的，this.left=null
//	3 如果当前节点的右子节点不为空，并且右子节点就是要删除的，this.Right=null
//  4 如果23步没有删除节点，那么就需要向左子树递归删除
//	5 如果4步没有删除节点，那么就需要向右子树递归删除

	public void deleteNode(int no) {
		
		if (this.leftnodNode!=null && this.leftnodNode.number ==no) {
			this.leftnodNode=null;
			return;
		}
		if (this.rightNode!=null && this.rightNode.number==no) {
			this.rightNode=null;
			return;
		}
		if(this.leftnodNode!=null) {
			this.leftnodNode.deleteNode(no);
		}
		if(this.rightNode!=null) {
			this.rightNode.deleteNode(no);
		}
	}

	public void deleteNode2(int no) {
		
		if (this.leftnodNode!=null && this.leftnodNode.number ==no) {
			if (this.leftnodNode.leftnodNode==null && this.leftnodNode.rightNode==null) {
				this.leftnodNode=null;
				return;
			}else if (this.leftnodNode.leftnodNode!=null && this.leftnodNode.rightNode!=null) {
				Node temp = this.leftnodNode.rightNode;
				this.leftnodNode = this.leftnodNode.leftnodNode;
				this.leftnodNode.rightNode= temp;
				return;
			}else if(this.leftnodNode.leftnodNode!=null){
				this.leftnodNode = this.leftnodNode.leftnodNode;
				return;
			}else {
				this.leftnodNode = this.leftnodNode.rightNode;
				return;
			}		
		}
		if (this.rightNode!=null && this.rightNode.number==no) {
			if (this.rightNode.leftnodNode==null && this.rightNode.rightNode==null) {
				this.rightNode=null;
				return;
			}else if (this.rightNode.leftnodNode!=null && this.rightNode.rightNode!=null) {
				Node temp = this.rightNode.rightNode;
				this.rightNode = this.rightNode.leftnodNode;
				this.rightNode.rightNode= temp;
				return;
			}else if(this.rightNode.leftnodNode!=null){
				this.rightNode = this.rightNode.leftnodNode;
				return;
			}else {
				this.rightNode = this.rightNode.rightNode;
				return;
			}		
		}
		
		if(this.leftnodNode!=null) {
			this.leftnodNode.deleteNode(no);
		}
		if(this.rightNode!=null) {
			this.rightNode.deleteNode(no);
		}
	}

	
}
