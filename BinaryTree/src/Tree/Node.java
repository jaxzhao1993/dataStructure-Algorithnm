package Tree;

public class Node {
	private int number;
	private String name;
	private Node leftnodNode;
	private Node rightNode;//Ĭ��ΪNull
	
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
	
	//ǰ�����
	public void preOrder() {
		//�������ǰ�ڵ�(���ڵ�)
		System.out.println(this);
		//�ݹ���������ǰ�����
		if (this.leftnodNode!= null) {
			this.leftnodNode.preOrder();
		}
		//�ݹ���������ǰ�����
		if (this.rightNode!=null) {
			this.rightNode.preOrder();
		}
	}
	
	//������� 
	public void infixOrder() {
		//�ݹ����������������
		if (this.leftnodNode!= null) {
			this.leftnodNode.infixOrder();
		}
		//�����ǰ�ڵ�(���ڵ�)
		System.out.println(this);
		//�ݹ����������������
		if (this.rightNode!=null) {
			this.rightNode.infixOrder();
		}
	}
	//��������
	public void postOrder() {
		//�ݹ����������������
		if (this.leftnodNode!= null) {
			this.leftnodNode.postOrder();
		}
		//�ݹ����������������
		if (this.rightNode!=null) {
			this.rightNode.postOrder();
		}
		//�����ǰ�ڵ�(���ڵ�)
		System.out.println(this);
	}
	
	public Node preOrderSearch(int no) {
		if(this.number == no)
		{
			return this;
		}
		//�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ�������ݹ�ǰ�����
		//�����ݹ�ǰ����ң��ҵ��ڵ㣬�򷵻�
		Node resNode = null;//��������Ƿ��ҵ��˽ڵ�
		if(this.leftnodNode!=null)
		{
			resNode = this.leftnodNode.preOrderSearch(no);
		}
		if(resNode!=null)
		{
			//˵�����������ҵ���
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

	//ɾ���Ļ����涨��
//	1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
//	2���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
//	
//	˼·��
//	1.��Ϊ���ǵĶ������ǵ���ģ�����������Ҫ����һ��ָ����ָ�򸸽ڵ�
//	2 �����ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���ģ�this.left=null
//	3 �����ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���ģ�this.Right=null
//  4 ���23��û��ɾ���ڵ㣬��ô����Ҫ���������ݹ�ɾ��
//	5 ���4��û��ɾ���ڵ㣬��ô����Ҫ���������ݹ�ɾ��

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
