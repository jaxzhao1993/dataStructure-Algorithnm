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
		//���Ǵ���Ĺ�����һ��ѭ����guoc
		while(list.size()>1) {
			Collections.sort(list);
			System.out.println(list);
			//ȡ�����ڵ�Ȩֵ��С�Ķ�����
			Node left = list.get(0);
			Node right = list.get(1);
			//�����µĶ�����
			Node parent = new Node(left.getValue() + right.getValue());
			parent.leftNode =left;
			parent.rightNode = right;
			//arraylist��ɾ�������������
			list.remove(left);
			list.remove(right);
			//��parent����list��
			list.add(parent);
			//Collections.sort(list);
			//System.out.println(list);
		}
		//����huffman��ͷ���
		return list.get(0);
	}
	
	public static void preOrder(Node root) {
		if(root!=null) {
			root.preOrder();
		}
		else {
			System.out.println("����");
		}
		
	}
}
