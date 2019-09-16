package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//按照字符出现的次数作为权值，构建huffman树

//根据huffman树，给各个字符进行编码，向左的路径为0，向右路径为1
//这个编码就是前缀编码
public class HuffmanCode {
	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		byte[] bytes = str.getBytes();
		System.out.println("压缩前：" + bytes.length);
		
		List<HuffmanNode> list = getNodes(bytes);
		System.out.println(list);
		//
		System.out.println("创建的huffman树");
		HuffmanNode node = createHuffmanTree(list);
		preOrder(node);
		
		getCode(node, stringBuilder, "");
		System.out.println("编码表" + huffmanCode);
		
	}
	//创建编码表
	/* 思路
	 * 1.放在map中Map《byte，string》
	 * 		32->1  97->100
	 * 2.在生成huffman编码表时，需要去拼接路径, stringbuilder存储
	 * 
	 *  */
	static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();
	static StringBuilder stringBuilder = new StringBuilder();
	
	/**
	 * 将传入的node节点的所有huffman编码得到，并放入到huffman code 中
	 * @param node 传入节点
	 * @param stringBuilder 路径：左0右1
	 * @param code
	 */
	private static void getCode(HuffmanNode node, StringBuilder stringBuilder, String code) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			//判断当前node是否是叶子节点
			if (node.dataByte == null) {
				//非叶子节点
				//向左递归
				getCode(node.left, stringBuilder2, "0");
				//向右递归
				getCode(node.right, stringBuilder2, "1");
			}else {
				//找到了叶子节点
				huffmanCode.put(node.dataByte, stringBuilder2.toString());
			}
		}
	}
	
	
	private static void preOrder(HuffmanNode node) {
		if(node == null)
		{
			System.out.println("树为空");
		}else {
			node.preOrder();
		}
	}
	
	private static List<HuffmanNode> getNodes(byte[] bytes) {
		//创建list
		List<HuffmanNode> list = new ArrayList<HuffmanNode>();
		//存储每个byte出现的个数,统计每个bytes出现次数
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
		//把每个键值对转成一个node 对象
		//遍历map
			for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
				list.add(new HuffmanNode(entry.getKey(), entry.getValue()));
			}
		return list;
	}

	//通过list创建huffman树
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
