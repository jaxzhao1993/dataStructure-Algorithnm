package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//�����ַ����ֵĴ�����ΪȨֵ������huffman��

//����huffman�����������ַ����б��룬�����·��Ϊ0������·��Ϊ1
//����������ǰ׺����
public class HuffmanCode {
	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		byte[] bytes = str.getBytes();
		System.out.println("ѹ��ǰ��" + bytes.length);
		
		List<HuffmanNode> list = getNodes(bytes);
		System.out.println(list);
		//
		System.out.println("������huffman��");
		HuffmanNode node = createHuffmanTree(list);
		preOrder(node);
		
		getCode(node, stringBuilder, "");
		System.out.println("�����" + huffmanCode);
		
	}
	//���������
	/* ˼·
	 * 1.����map��Map��byte��string��
	 * 		32->1  97->100
	 * 2.������huffman�����ʱ����Ҫȥƴ��·��, stringbuilder�洢
	 * 
	 *  */
	static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();
	static StringBuilder stringBuilder = new StringBuilder();
	
	/**
	 * �������node�ڵ������huffman����õ��������뵽huffman code ��
	 * @param node ����ڵ�
	 * @param stringBuilder ·������0��1
	 * @param code
	 */
	private static void getCode(HuffmanNode node, StringBuilder stringBuilder, String code) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			//�жϵ�ǰnode�Ƿ���Ҷ�ӽڵ�
			if (node.dataByte == null) {
				//��Ҷ�ӽڵ�
				//����ݹ�
				getCode(node.left, stringBuilder2, "0");
				//���ҵݹ�
				getCode(node.right, stringBuilder2, "1");
			}else {
				//�ҵ���Ҷ�ӽڵ�
				huffmanCode.put(node.dataByte, stringBuilder2.toString());
			}
		}
	}
	
	
	private static void preOrder(HuffmanNode node) {
		if(node == null)
		{
			System.out.println("��Ϊ��");
		}else {
			node.preOrder();
		}
	}
	
	private static List<HuffmanNode> getNodes(byte[] bytes) {
		//����list
		List<HuffmanNode> list = new ArrayList<HuffmanNode>();
		//�洢ÿ��byte���ֵĸ���,ͳ��ÿ��bytes���ִ���
		Map<Byte, Integer> counts = new HashMap<Byte, Integer>();
		//
		for (byte b: bytes) {
			Integer count = counts.get(b);
			if (count ==null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
		}
		//��ÿ����ֵ��ת��һ��node ����
		//����map
			for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
				list.add(new HuffmanNode(entry.getKey(), entry.getValue()));
			}
		return list;
	}

	//ͨ��list����huffman��
	private static HuffmanNode createHuffmanTree(List<HuffmanNode> list) {
		HuffmanNode leftNode;
		HuffmanNode rightNode;
		while (list.size()>1) {
			Collections.sort(list);
			leftNode = list.get(0);
			rightNode = list.get(1);
			HuffmanNode parent = new HuffmanNode(null, leftNode.weight+ rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			list.remove(leftNode);
			list.remove(rightNode);
			list.add(parent);
		}
		return list.get(0);
	}

}
