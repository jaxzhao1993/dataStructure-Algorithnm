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
			System.out.println("空树");
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
			//如果发现target没有父节点
			if(rootNode.leftNode ==null && rootNode.rightNode ==null){
				rootNode =null;
				return;
			}
			
			
			Node parentNode = searchParent(target);
			if (parentNode == null) {
				
			}
			
			//如果删除节点是叶子节点
			if(targetNode.leftNode ==null && targetNode.rightNode == null) {
				//判断是左子还是右子
				if (parentNode.leftNode == targetNode) {
					parentNode.leftNode = null;
				}else {
					parentNode.rightNode = null;
				}
			}
			
			//如果删除节点有一个子节点
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
			
			//如果删除节点有一个子树,左右子都不为空
			else if (targetNode.leftNode!=null && targetNode.rightNode !=null) {
				int temp = targetNode.rightNode.searchMini();
				deleteNode(temp);
				targetNode.value = temp;
			}
		}
	}
}
