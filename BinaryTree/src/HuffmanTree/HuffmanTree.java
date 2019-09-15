package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	public static void main(String[] args) {
		int[] array = {13,7,8,3,29,6,1};
		Node rootNode = createHuffmanTree(array);
		preOrder(rootNode);
		
	}
	
	public static Node createHuffmanTree(int[] array) {
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < array.length; i++) {
			list.add(new Node(array[i]));
		}
		//我们处理的过程是一个循环的guoc
		while(list.size()>1) {
			Collections.sort(list);
			System.out.println(list);
			//取出根节点权值最小的二叉树
			Node left = list.get(0);
			Node right = list.get(1);
			//构建新的二叉树
			Node parent = new Node(left.getValue() + right.getValue());
			parent.leftNode =left;
			parent.rightNode = right;
			//arraylist中删除处理过的数据
			list.remove(left);
			list.remove(right);
			//将parent加入list中
			list.add(parent);
			//Collections.sort(list);
			//System.out.println(list);
		}
		//返回huffman的头结点
		return list.get(0);
	}
	
	public static void preOrder(Node root) {
		if(root!=null) {
			root.preOrder();
		}
		else {
			System.out.println("空树");
		}
		
	}
}
