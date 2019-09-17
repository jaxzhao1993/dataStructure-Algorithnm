package HuffmanTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



//�����ַ����ֵĴ�����ΪȨֵ������huffman��

//����huffman�����������ַ����б��룬�����·��Ϊ0������·��Ϊ1
//����������ǰ׺����
public class HuffmanCode {
	public static void main(String[] args) {
		//ѹ���ַ���
//		String str = "i like like like java do you like a java";
//		byte[] bytes = str.getBytes();
//		System.out.println(Arrays.toString(bytes));
//
//		byte[] after = huffmanZip(bytes);
//		System.out.println(Arrays.toString(after));
//		
//		byte[] afterParse = parse(huffmanCode, after);
//		System.out.println(new String(afterParse));
		
		//ѹ���ļ�
//		String srcFile = "d://src.pdf";
//		String dstFile = "d://src.zly";
//		zip(srcFile, dstFile);
		
		//��ѹ��
		
//		System.out.println("ѹ�����");
//		System.out.println("ѹ��ǰ��" + bytes.length);
//		
//		List<HuffmanNode> list = getNodes(bytes);
//		System.out.println(list);
//		//
//		System.out.println("������huffman��");
//		HuffmanNode node = createHuffmanTree(list);
//		preOrder(node);
//		
////		getCode(node, stringBuilder, "");
//		Map<Byte, String> hufffmanCode = getCode(node);
//		//System.out.println("�����" + huffmanCode);
//		byte[] after =  zip(bytes, hufffmanCode);
//		System.out.println("huffmancode" + Arrays.toString(after));
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
	 * @param bytes ԭʼ��������Ӧ���ֽ�����
	 * @return ѹ��֮����ֽ�����
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		List<HuffmanNode> huffmanList = getNodes(bytes);
		HuffmanNode root = createHuffmanTree(huffmanList);
		Map<Byte, String> huffmanMap= getCode(root);
		byte[] bytes2 = zip(bytes, huffmanMap);
		return bytes2;
	}
	
	
	/**
	 * �������node�ڵ������huffman����õ��������뵽huffman code ��
	 * @param node ����ڵ�
	 * @param stringBuilder ·������0��1
	 * @param code
	 * @return 
	 */
	private static Map<Byte, String> getCode(HuffmanNode node) {
		if(node==null)
		{
			return null;
		}
		//�������ӽڵ�
		getCode(node.left, stringBuilder, "0");
		//�������ӽڵ�
		getCode(node.right, stringBuilder, "1");
		return huffmanCode;
	}
	
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

	//��дһ�����������ַ�����Ӧ��byte�������飬ͨ�����ɵ�huffman���룬����һ��ѹ�����byte����
	private static byte[] zip(byte[] bytes, Map<Byte, String > hufffmanCode) {
		//����huffmanCode�������bytes���飬ת����huffman��Ӧ���ַ���
		StringBuilder stringBuilder = new StringBuilder();
		//����bytes����
		for (byte b : bytes) {
			stringBuilder.append(hufffmanCode.get(b));
		}
		//System.out.println("string builder" + stringBuilder.toString());
		//�� 10101000111.������ת��byte����
		int len;
		if(stringBuilder.length()%8 ==0) {
			len = stringBuilder.length()/8;
		}else {
			len = stringBuilder.length()/8+1;
			}
		//�����洢ѹ�����byte����
		int index = 0;
		byte[] by = new byte[len];
		for (int i = 0; i < stringBuilder.length(); i+=8) { // ÿ8λ��Ӧһ��byte�����Բ���+8
			String strByte;
			if(i+8> stringBuilder.length()) {
				//����8λ
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i+8);
			}
			//��strByteת��һ��byte,���뵽by��
			by[index] = (byte)Integer.parseInt(strByte, 2);
			index ++ ;
		}
				return by;
	}
	
	
	//������ݵĽ�ѹ
	/* ˼· 
	 * 1. ��huffman����[-88, -65, -56, -65��������]ת�ɶ�Ӧ��2�����ַ���
	 * 
	 * */
	private static String byteToBitString(Boolean flag, byte b) {
		//ʹ�ñ�������b
		int temp = b;
		if (flag) {
			temp |= 256; //��λ��256 1 0000 0000 | 0000 0001 => 1 0000 0001
		}
		String str =  Integer.toBinaryString(temp); //����temp�Ķ����Ʋ���
		if (flag) {
			return str.substring(str.length()-8);
		}else {
			return str;
		}
	}
	
	//��дһ����������ɽ���
	/**
	 * @param huffMap �����
	 * @param bytes
	 * ����ԭ���ַ�����Ӧ������
	 * @return 
	 */ 
	private static byte[] parse(Map<Byte, String> huffmanCode, byte[] bytes) {
		//1.�ȵõ�bytes��Ӧ�Ķ������ַ���
		StringBuilder stringBuilder = new StringBuilder();
		//��byte����ת�ɶ������ַ���
		for(int i =0; i<bytes.length; i++ ){
			boolean flag = (i == bytes.length-1);
			stringBuilder.append(byteToBitString(!flag, bytes[i]));
		}
		System.out.println("�����" +stringBuilder.toString());
		//���ַ�������ָ��������н���
		//��huffmanMap��ֵ��key����
		Map<String, Byte> parseMap = new HashMap<String, Byte>();
		for(Map.Entry<Byte, String> entry: huffmanCode.entrySet()) {
			parseMap.put(entry.getValue(), entry.getKey());
		}
		System.out.println(parseMap);
		//���byte
		List<Byte> list = new ArrayList<Byte>();
		for (int i=0; i<stringBuilder.length(); ) {
			int count =1 ; //ɨ�������
			boolean flag = true;
			Byte b = null;
			while (flag) {
				//ȡ��һ���ַ�
				String key = stringBuilder.substring(i,i+count);//i��������count�ƶ� ��ֱ��ƥ�䵽һ���ַ�
				b= parseMap.get(key);
				if (b!=null){
					flag = false;
				}else {
					count++;
				}
			}
			i = i+count;
			list.add(b);	
		}
		//ѭ��������list�ʹ�������е��ַ�
		byte[] byteResult= new byte[list.size()];
		for(int i = 0; i<byteResult.length; i++) {
			byteResult[i] = list.get(i);
		}
		return byteResult;
	}
	
	/**
	 * @param zipFile Ҫѹ�����ļ�
	 * @param dstFile ѹ��������
	 */
	public static void zip(String srcFile, String dstFile) {
		FileInputStream is = null;
		FileOutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			//�����ļ�������
			is = new FileInputStream(srcFile);
			//����һ����Դ�ļ�һ����С��byte[]
			byte[] b = new byte[is.available()];
			//��ȡ�ļ�
			is.read(b);
			//ʹ��huffman�����
			byte[] after = huffmanZip(b);
			//ʹ������������ѹ���ļ�
			os = new FileOutputStream(dstFile);
			//����һ�����ļ�������������ObjectOutputStream
			oos = new ObjectOutputStream(os);
			//�Զ������ķ�ʽд��huffman���룬Ŀ����Ϊ���Ժ����ǽ�ѹʱʹ��
			//һ��Ҫ��huffman����д��ѹ���ļ�
			oos.writeObject(after);
			oos.writeObject(huffmanCode);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				is.close();
				os.close();
				oos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void unZip(String zipFile, String dstFile) {
		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		try {
			//�����ļ�������
			is = new FileInputStream(zipFile);
			//����object stream
			ois = new ObjectInputStream(is);
			byte[] src = (byte[])ois.readObject();
			//��ȡhuffman�����
			Map<Byte, String> codeMap = (Map<Byte, String>)ois.readObject();
			//����
			byte[] bytes = parse(codeMap, src);
			//���
			os = new FileOutputStream(dstFile);
			os.write(bytes);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				os.close();
				ois.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
