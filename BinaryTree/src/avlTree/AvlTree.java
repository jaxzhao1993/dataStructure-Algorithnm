package avlTree;

public class AvlTree {
	private Node rootNode;
	
	public void add(Node node) {
		if(rootNode ==null) {
			rootNode = node;
		}else {
			rootNode.add(node);
		}
	}
	
	public void infixOrder() {
		if (rootNode!=null) {
			rootNode.infixOrder();
		} else {
			System.out.println("����");
		}
	}

	public Node search(int target) {
		if (this.rootNode ==null) {
			return null;
		}else {
			return this.rootNode.search(target);
		}
	}
	
	public Node searchParent(int target) {
		if(this.rootNode == null) {
			return null;
		}else {
			return this.rootNode.searchParent(target);
		}
	}

	
	
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	public void deleteNode(int target) {
		if (rootNode == null) {
			return;
		}else {
			Node targetNode = rootNode.search(target);
			if (targetNode ==null) {
				return;
			}
			//�������targetû�и��ڵ�
			if(rootNode.leftNode ==null && rootNode.rightNode ==null){
				rootNode =null;
				return;
			}
			
			
			Node parentNode = searchParent(target);
			if (parentNode == null) {
				
			}
			
			//���ɾ���ڵ���Ҷ�ӽڵ�
			if(targetNode.leftNode ==null && targetNode.rightNode == null) {
				//�ж������ӻ�������
				if (parentNode.leftNode == targetNode) {
					parentNode.leftNode = null;
				}else {
					parentNode.rightNode = null;
				}
			}
			
			//���ɾ���ڵ���һ���ӽڵ�
			else if (!(targetNode.leftNode != null && targetNode.rightNode!=null)) {
				if (parentNode!= null &&parentNode.leftNode==targetNode) {
					if (targetNode.leftNode!=null ) {
						parentNode.leftNode =targetNode.leftNode;
					}else {
						parentNode.leftNode =targetNode.rightNode;
					}
				}else if (parentNode!= null &&parentNode.rightNode==targetNode)   {
					if (targetNode.rightNode!=null) {
						parentNode.rightNode = targetNode.rightNode;
					}else {
						parentNode.rightNode =targetNode.leftNode;
					}
				}else {
					if (parentNode == null && targetNode.leftNode!=null) {
						rootNode = targetNode.leftNode;
					}else {
						rootNode =targetNode.rightNode;
					}
				}
			}
			
			//���ɾ���ڵ���һ������,�����Ӷ���Ϊ��
			else if (targetNode.leftNode!=null && targetNode.rightNode !=null) {
				int temp = targetNode.rightNode.searchMini();
				deleteNode(temp);
				targetNode.value = temp;
			}
		}
	}
}
